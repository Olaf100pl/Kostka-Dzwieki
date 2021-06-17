package com.example.kostkaidziewki

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kostkaidziewki.databinding.ActivityDzwiekiBinding


private var mPlayer: MediaPlayer? = null

class Dzwieki : AppCompatActivity() {
    private lateinit var binding: ActivityDzwiekiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDzwiekiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnAudio1.setOnClickListener { btnAudio1Clicked() }
        binding.btnAudio2.setOnClickListener { btnAudio2Clicked() }
        binding.btnAudio3.setOnClickListener { btnAudio3Clicked() }
        binding.btnAudio4.setOnClickListener { btnAudio4Clicked() }
        binding.btnAudio5.setOnClickListener { btnAudio5Clicked() }
        binding.btnAudio6.setOnClickListener { btnAudio6Clicked() }
        binding.btnPause.setOnClickListener {  btnPauseClicked()}
        binding.btnClose.setOnClickListener { btnCloseClicked() }
    }

    private fun playAudio(resId: Int) {
        binding.btnPause.text = "Pause"
        //jeśli nie pusty to zwolnij miejsce
        if (mPlayer != null) {
            mPlayer!!.release()
        }

        mPlayer = MediaPlayer.create(this, resId)
        mPlayer!!.start()
    }

    private fun btnPauseClicked(){
        if (mPlayer != null){
            if (mPlayer!!.isPlaying){
                mPlayer!!.pause()
                binding.btnPause.text = "Play"
            } else {
                mPlayer!!.start()
                binding.btnPause.text = "Pause"
            }
        }
    }



    private fun btnAudio1Clicked () {
        playAudio(R.raw.szlaban)
    }

    private fun btnAudio2Clicked () {
        playAudio(R.raw.bardzozabawne)
    }

    private fun btnAudio3Clicked () {
        playAudio(R.raw.cocojumbo)
    }

    private fun btnAudio4Clicked () {
        playAudio(R.raw.muzyczka1)
    }

    private fun btnAudio5Clicked () {
        playAudio(R.raw.muzyczka2)
    }

    private fun btnAudio6Clicked () {
        playAudio(R.raw.muzyczka3)
    }

    private fun btnCloseClicked() {
        finish()
    }


    

}