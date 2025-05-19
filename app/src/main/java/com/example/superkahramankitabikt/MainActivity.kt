package com.example.superkahramankitabikt

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superkahramankitabikt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
         lateinit var binding: ActivityMainBinding

         lateinit var  superKahramanlarListesi: ArrayList<SuperKahramanlar>

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val batman  = SuperKahramanlar("Batman","Gazeteci",R.drawable.batman)
        val ironman  = SuperKahramanlar("İronman","Matbaacı",R.drawable.ironman)
        val superman  = SuperKahramanlar("Superman","Tekstilci",R.drawable.superman)
        val aquaman = SuperKahramanlar("Aquaman","Tekstilci",R.drawable.aquaman)

        superKahramanlarListesi = arrayListOf(batman,ironman,aquaman,superman)

        val adapter = SuperKahramanAdapter(superKahramanlarListesi)

        binding.SuperKahramanRV.layoutManager  = LinearLayoutManager(this)
        binding.SuperKahramanRV.adapter = adapter

    }
}