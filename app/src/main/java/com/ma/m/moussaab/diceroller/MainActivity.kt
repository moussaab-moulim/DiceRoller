package com.ma.m.moussaab.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/*this activity allows the user to roll a dice and view results
on the screen*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button_1)

        rollButton.setOnClickListener {
            val toast: Toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_LONG)
            toast.show()
            rollDice()
        }
    }

    /**
     * roll the dice and update the ui with the results
     */
    private fun rollDice() {

        // create instance of the dice class with 6 sides
        val dice1 = Dice(6)
        val diceRoll1 = dice1.roll()
        /*// create a second  instance of the dice class with 6 sides
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()*/

        // update the text view with rolled dice 1 results
        val diceTextView1: TextView = findViewById(R.id.dice_textView_1)
        diceTextView1.text = diceRoll1.toString()
        /*// update the text view with rolled dice 2 results
        val diceTextView2: TextView = findViewById(R.id.dice_textView_2)
        diceTextView2.text = diceRoll2.toString()*/
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}