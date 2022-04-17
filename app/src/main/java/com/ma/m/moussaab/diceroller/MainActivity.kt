package com.ma.m.moussaab.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/*this activity allows the user to roll a dice and view results
on the screen*/
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logging()
        //do a dice roll when the app starts
        rollDice()


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
        //get a random side number
        val diceRoll1 = dice1.roll()

        // find the imageview in the layout
        val diceImageView1: ImageView = findViewById(R.id.dice_image_1)
        //determine the with drawable resource id to use based on the random dice number
        val dice_id: Int = this.applicationContext.resources.getIdentifier(
            "dice_$diceRoll1",
            "drawable",
            packageName
        )
        // set the resource with the correct id to the image view
        diceImageView1.setImageResource(dice_id)
        // set the content description to the dice image
        diceImageView1.contentDescription="dice rolled on number $diceRoll1"



        /*// create a second  instance of the dice class with 6 sides
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()

        // update the text view with rolled dice 1 results
        val diceTextView1: TextView = findViewById(R.id.dice_textView_1)
        diceTextView1.text = diceRoll1.toString()
        // update the text view with rolled dice 2 results
        val diceTextView2: TextView = findViewById(R.id.dice_textView_2)
        diceTextView2.text = diceRoll2.toString()*/
    }
    fun logging(){
        Log.wtf(TAG,"Hello, World! hhhhhhh")
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}