package com.kolot.x_servicesbeta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kolot.x_servicesbeta.databinding.ActivityMainBinding
import com.kolot.x_servicesbeta.databinding.ActivityPengaturanBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.BtnHome
import kotlinx.android.synthetic.main.activity_main.BtnPengaturan
import kotlinx.android.synthetic.main.activity_main.BtnPesan
import kotlinx.android.synthetic.main.activity_pengaturan.*

class Pengaturan : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPengaturanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPengaturanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BtnPengaturan.setOnClickListener(this)
        binding.BtnPesan.setOnClickListener(this)
        binding.BtnHome.setOnClickListener(this)
        binding.BtnTentang.setOnClickListener(this)
        binding.btnPengaturanUser.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.BtnPengaturan -> {
                val intent = Intent(this@Pengaturan, Pengaturan::class.java)
                startActivity(intent)
            }
            R.id.BtnPesan -> {
                val intent = Intent(this@Pengaturan, Pesan::class.java)
                startActivity(intent)
            }
            R.id.BtnHome -> {
                val intent = Intent(this@Pengaturan, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.BtnTentang -> {
                val intent = Intent(this@Pengaturan, Tentang::class.java)
                startActivity(intent)
            }
            R.id.btnPengaturanUser -> {
                val intent = Intent(this@Pengaturan, PengaturanUserActivity::class.java)
                startActivity(intent)
            }
        }
    }
}