package com.example.numberguessinggame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var imageButtonCheck: ImageButton
    lateinit var button: Button
    lateinit var textViewHint: TextView
    private lateinit var textViewCount: TextView
    var counts = 0

    var random: Int = nextInt(1, 1000)

    fun reset() {

        random = nextInt(1, 1000)
        counts = 0
        textViewCount.text = "Wrong Answer: 0"
        textViewHint.text = ""
        editText.text.clear()

    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText  = findViewById(R.id.editText)
        imageButtonCheck = findViewById(R.id.imageButtonCheck)
        button = findViewById(R.id.button)
        textViewHint = findViewById(R.id.textViewHint)
        textViewCount = findViewById(R.id.textViewCount)

        imageButtonCheck.setOnClickListener {

            val number: Int = editText.text.toString().toInt()

            if (number > random) {

                textViewHint.text = "Hint: It's lower!!"
                editText.text.clear()
                counts++

            } else if (number < random) {

                counts++
                textViewHint.text = "Hint: It's higher!!"
                editText.text.clear()


            } else {

                textViewHint.text = "Correct!"
                editText.text.clear()

            }

            textViewCount.text = "Wrong Answer: $counts"
        }

        button.setOnClickListener {

            reset()

        }
    }



}