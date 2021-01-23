package com.dscreva.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var trialView: TextView
    lateinit var scoreView: TextView
    lateinit var roll_me: Button
    var trials: Int = 9
    var previous_number = 0
    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)
        trialView = findViewById(R.id.trails)
        scoreView = findViewById(R.id.score)
        roll_me = findViewById(R.id.roll_me)
        roll_me.setOnClickListener {
            if (trials > 0) {
                val number = Random().nextInt(6) + 1
                if (previous_number == number) {
                    if (previous_number == 6) {
                        //OUT
                        Toast.makeText(this, "YOU ARE OUT, ROLL THE DICE AGAIN TO RESTART", Toast.LENGTH_LONG).show()
                        score = 0
                        previous_number = 0
                        trials = 9
                    } else if (previous_number == 3) {
                        // Extra trial
                        trials += 1
                    }
                }
                if (number == 1) {
                    imageView.setImageResource(R.drawable.dice1)
                } else if (number == 2) {
                    imageView.setImageResource(R.drawable.dice2)
                } else if (number == 3) {
                    imageView.setImageResource(R.drawable.dice3)
                } else if (number == 4) {
                    imageView.setImageResource(R.drawable.dice4)
                } else if (number == 5) {
                    imageView.setImageResource(R.drawable.dice5)
                } else {
                    imageView.setImageResource(R.drawable.dice6)
                }
                trials -= 1
                score += number
                if (score >= 30) {
                    Toast.makeText(this, "HURRAY!, YOU ARE A WINNER", Toast.LENGTH_LONG).show()
                }
                trialView.text = "Trails left : $trials"
                scoreView.text = "score : $score"
                previous_number = number
            } else {
                Toast.makeText(this, "TRIALS ARE OVER, CLOSE THE APP AND START AGAIN", Toast.LENGTH_LONG).show()
            }
        }
    }
}