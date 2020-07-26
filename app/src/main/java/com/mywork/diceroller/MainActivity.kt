package com.mywork.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonRoll.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        imageViewDice.setImageResource(getImage(diceRoll))
        imageViewDice.contentDescription = diceRoll.toString()

        val diceRoll2 = dice.roll()
        imageViewDiceTwo.setImageResource(getImage(diceRoll2))
        imageViewDiceTwo.contentDescription = diceRoll2.toString()
    }


    private fun getImage(diceRoll:Int) : Int{
      return  when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}