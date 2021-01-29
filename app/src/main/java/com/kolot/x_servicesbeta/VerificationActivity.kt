package com.kolot.x_servicesbeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.kolot.x_servicesbeta.databinding.ActivityPhoneAuthBinding
import com.kolot.x_servicesbeta.databinding.ActivityVerificationBinding
import java.util.concurrent.TimeUnit

class VerificationActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityVerificationBinding
    private var verificationInProgress = false
    private var storedVerificationId: String? = ""
    private var prefixPhoneNumber: String? = "+62"
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnContinue.setOnClickListener(this)
        auth = Firebase.auth
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                verificationInProgress = false
                signInWithPhoneAuthCredential(credential)
            }
            override fun onVerificationFailed(e: FirebaseException) {
                verificationInProgress = false
                if (e is FirebaseAuthInvalidCredentialsException) {
                    Snackbar.make(findViewById(android.R.id.content), "Invalid phone number.",
                        Snackbar.LENGTH_SHORT).show()
                } else if (e is FirebaseTooManyRequestsException) {
                    Snackbar.make(findViewById(android.R.id.content), "Quota exceeded.",
                        Snackbar.LENGTH_SHORT).show()
                }
            }
            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                storedVerificationId = verificationId
                resendToken = token
            }
        }
    }
    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnContinue -> {
                val code = binding.inputVerifyCode.text.toString()
                if (TextUtils.isEmpty(code)) {
                    binding.inputVerifyCode.error = "Cannot be empty."
                    return
                }
                verifyPhoneNumberWithCode(storedVerificationId, code)
            }
        }
    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    finish()
                } else {
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        binding.inputVerifyCode.error = "Invalid code."
                    }
                }
            }
    }
    private fun verifyPhoneNumberWithCode(verificationId: String?, code: String) {
        val credential = PhoneAuthProvider.getCredential(verificationId!!, code)
        signInWithPhoneAuthCredential(credential)
    }
}