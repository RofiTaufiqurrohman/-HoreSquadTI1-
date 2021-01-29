package com.kolot.x_servicesbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.kolot.x_servicesbeta.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        val currentUser = auth.currentUser
        if (currentUser == null) {
            val intent = Intent(this@MainActivity, SignInActivity::class.java)
            startActivity(intent)
            finish()
        BtnPesan.setOnClickListener{
            val intent = Intent(this, Pesan::class.java)
            startActivity(intent)
        }
        BtnPengaturan.setOnClickListener{
            val intent = Intent(this, Pengaturan::class.java)
            startActivity(intent)
        }
        BtnHome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        BtnBerita.setOnClickListener{
            val intent = Intent(this, Berita::class.java)
            startActivity(intent)
        }
        BtnPemberitahuan.setOnClickListener{
            val intent = Intent(this, Pemberitahuan::class.java)
            startActivity(intent)
        }
        BtnBuat.setOnClickListener{
            val intent = Intent(this, Pemberitahuan::class.java)
            startActivity(intent)
        }
        BtnCek.setOnClickListener{
            val intent = Intent(this, CekPesanan::class.java)
            startActivity(intent)
        }
    }
}
    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser == null) {
            val intent = Intent(this@MainActivity, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
