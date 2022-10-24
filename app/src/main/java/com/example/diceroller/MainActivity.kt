package com.example.diceroller
// All source code and instruction from Android developer online training
//

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

// Users can roll dice, then the number of the dice roll is displayed
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }

        // Demo the app with a dice roll on startup
        rollDice()
    }

    private fun rollDice()
    {
        // Set # of sides for dice
        val dice = Dice(6)
        // Roll the die
        val diceRoll = dice.roll()
        // Creates an imageView to show the image of our die
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Gets the drawable resource ID as a result of the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Sets the image view as the new correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        // Update the content description (for screen reading function of device)
        diceImage.contentDescription = diceRoll.toString()
        }
}


private class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}