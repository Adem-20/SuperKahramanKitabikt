package com.example.superkahramankitabikt

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.superkahramankitabikt.databinding.ActivityMainBinding
import com.example.superkahramankitabikt.databinding.ActivityTanitimAktivitesiBinding

class TanitimAktivitesi : AppCompatActivity() {

    lateinit var binding: ActivityTanitimAktivitesiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityTanitimAktivitesiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapterdenGelenIntent = intent

       val  secilenKahraman =  adapterdenGelenIntent.getSerializableExtra("SecilenKahraman") as SuperKahramanlar

        binding.imageView.setImageResource(secilenKahraman.gorsel)
        binding.textViewIsim.text = secilenKahraman.isim
        binding.textViewMeslek.text  = secilenKahraman.meslek
    }
}