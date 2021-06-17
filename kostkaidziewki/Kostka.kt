package com.example.kostkaidziewki

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kostkaidziewki.databinding.ActivityKostkaBinding
import java.util.*
import kotlin.concurrent.schedule

class Kostka : AppCompatActivity() {
    private lateinit var binding: ActivityKostkaBinding
    private var animKostka: AnimationDrawable = AnimationDrawable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityKostkaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLosujKostke.setOnClickListener { btnLosujKoskteClicked() }
        binding.btnBack.setOnClickListener { btnBackClicked() }

    }

    //losowanie
     private fun btnLosujKoskteClicked(){
        //wyświetla animacje losowania kostki
        binding.imgvKostka.setImageResource(0)
        binding.imgvKostka.setBackgroundResource(R.drawable.animacjakostki)
        animKostka = binding.imgvKostka.background as AnimationDrawable
        animKostka.start()
        binding.btnLosujKostke.isEnabled = false

        // po dwóch sekundach pokazuje mi wynik
        Timer().schedule(2000){
            cancel()
            wylosowane()

        }

     }

    private fun wylosowane(){
        animKostka.stop()

        runOnUiThread {
            when ( (1..5).random()) {
                1 -> {
                    binding.imgvKostka.setImageResource(R.drawable.kostka1)
                    binding.textLabelKostka.text = "Wylosowałeś 1"
                }
                2 -> {
                    binding.imgvKostka.setImageResource(R.drawable.kostka2)
                    binding.textLabelKostka.text = "Wylosowałeś 2"
                }
                3 -> {
                    binding.imgvKostka.setImageResource(R.drawable.kostka3)
                    binding.textLabelKostka.text = "Wylosowałeś 3"
                }
                4 -> {
                    binding.imgvKostka.setImageResource(R.drawable.kostka4)
                    binding.textLabelKostka.text = "Wylosowałeś 4"
                }
                5 -> {
                    binding.imgvKostka.setImageResource(R.drawable.kostka5)
                    binding.textLabelKostka.text = "Wylosowałeś 5"
                }
                6 -> {
                    binding.imgvKostka.setImageResource(R.drawable.kostka6)
                    binding.textLabelKostka.text = "Wylosowałeś 6"
                }
            }
            binding.btnLosujKostke.isEnabled = true
        }
    }


    //powrót do ekranu głównego
    private fun btnBackClicked(){
        finish()
    }

}