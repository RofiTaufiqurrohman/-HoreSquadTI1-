package com.kolot.x_servicesbeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kolot.x_servicesbeta.databinding.ActivityCekPesananBinding
import com.kolot.x_servicesbeta.databinding.ActivityPengaturanBinding

class CekPesanan : AppCompatActivity() {
    private lateinit var binding: ActivityCekPesananBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCekPesananBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}