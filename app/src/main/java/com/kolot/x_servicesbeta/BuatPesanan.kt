package com.kolot.x_servicesbeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kolot.x_servicesbeta.databinding.ActivityBuatPesananBinding
import com.kolot.x_servicesbeta.databinding.ActivityPengaturanBinding

class BuatPesanan : AppCompatActivity() {
    private lateinit var binding: ActivityBuatPesananBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuatPesananBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}