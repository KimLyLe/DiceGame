package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun updateUI() {
        textView2.text = getString(R.string.textView2, lastThrow)

        when (currentThrow) {
            1 -> imageView2.setImageResource(R.drawable.dice1)
            2 -> imageView2.setImageResource(R.drawable.dice2)
            3 -> imageView2.setImageResource(R.drawable.dice3)
            4 -> imageView2.setImageResource(R.drawable.dice4)
            5 -> imageView2.setImageResource(R.drawable.dice5)
            6 -> imageView2.setImageResource(R.drawable.dice6)
        }
    }

private fun initView() {
        button.setOnClickListener {
            onLowerClick()
        }
        button5.setOnClickListener {
            onEqualClick()
        }
        button3.setOnClickListener {
            onHigherClick()
        }
        updateUI()
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick() {
        rollDice()
        if (currentThrow > lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onLowerClick() {
        rollDice()
        if (currentThrow < lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onEqualClick() {
        rollDice()
        if (currentThrow == lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onAnswerCorrect() {
    Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_SHORT).show()
}

    private fun onAnswerIncorrect() {
    Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show()
}


}
