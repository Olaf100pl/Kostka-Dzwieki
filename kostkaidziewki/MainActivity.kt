package com.example.kostkaidziewki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kostkaidziewki.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLosuj.setOnClickListener{ btnLosujOnClick() }
        binding.btnKostka.setOnClickListener { btnKostkaOnClick() }
        binding.btnDzwieki.setOnClickListener { btnDzwiekiClicked() }

    }

    //do losowania tekstów na głównym ekranie
    private fun btnLosujOnClick(){

        var napis: String = ""
        when ( (1..5).random()) {
            1 -> napis = "Witaj"
            2 -> napis = "Cześć"
            3 -> napis = "Dzień dobry"
            4 -> napis = "Hejka"
            5 -> napis = "Siema"
            6 -> napis = "Hello"
        }
        binding.txtLabelHello.text = napis

    }

    //przejście do kostki
    private fun btnKostkaOnClick(){
        val intent = Intent(this, Kostka::class.java)
        startActivity(intent)
    }

    //przejście do dźwięków
    private fun btnDzwiekiClicked(){
        val intent = Intent(this, Dzwieki::class.java)
        startActivity(intent)
    }



}