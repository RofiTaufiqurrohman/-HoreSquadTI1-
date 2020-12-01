package com.kolot.x_servicesbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.BtnHome
import kotlinx.android.synthetic.main.activity_main.BtnPengaturan
import kotlinx.android.synthetic.main.activity_main.BtnPesan
import kotlinx.android.synthetic.main.activity_pengaturan.*

class Pengaturan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengaturan)
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
        BtnTentang.setOnClickListener{
            val intent = Intent(this, Tentang::class.java)
            startActivity(intent)
        }
    }

}