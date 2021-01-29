package com.kolot.x_servicesbeta

import android.content.Intent
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
import java.util.concurrent.TimeUnit

class PhoneAuthActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityPhoneAuthBinding
    private var verificationInProgress = false
    private var storedVerificationId: String? = ""
    private var prefixPhoneNumber: String? = "+62"
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnVerify.setOnClickListener(this)
        auth = Firebase.auth
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                verificationInProgress = false
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
            R.id.btnVerify -> {
                val intent = Intent(this@PhoneAuthActivity,
                    VerificationActivity::class.java)
                startActivity(intent)
                val phoneNumber = binding.inputNumber.text.toString()
                if (TextUtils.isEmpty(phoneNumber)) {
                    binding.inputNumber.error = "Invalid phone number."
                    return
                }

                startPhoneNumberVerification(prefixPhoneNumber+binding.inputNumber.text.toString
                    ())
            }
        }
    }
    private fun startPhoneNumberVerification(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
        verificationInProgress = true
    }
}