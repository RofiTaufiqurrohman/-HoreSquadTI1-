package com.kolot.x_servicesbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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