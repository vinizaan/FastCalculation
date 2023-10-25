package com.github.vinizaan.fastcalculation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.vinizaan.fastcalculation.databinding.ActivityFinishedGameBinding

class FinishedGameActivity : AppCompatActivity() {
    private val activityFinishedGameBinding: ActivityFinishedGameBinding by lazy {
        ActivityFinishedGameBinding.inflate(layoutInflater)
    }
    private lateinit var settings: Settings
    private var points: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityFinishedGameBinding.root)

        points = intent.getStringExtra(Extras.EXTRA_POINTS) ?: "0.0"
        settings = intent.getParcelableExtra(Extras.EXTRA_SETTINGS) ?: Settings()

        activityFinishedGameBinding.apply {

            resultsTv.text = points.toString()

            restarGameBt.setOnClickListener {
                val gameActivityIntent = Intent(this@FinishedGameActivity, GameActivity::class.java)
                gameActivityIntent.putExtra(Extras.EXTRA_SETTINGS, settings)
                startActivity(gameActivityIntent)
                finish()
             }
        }
    }
}