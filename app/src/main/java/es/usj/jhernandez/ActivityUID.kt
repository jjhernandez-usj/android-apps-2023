package es.usj.jhernandez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import es.usj.jhernandez.databinding.ActivityUibBinding
import es.usj.jhernandez.databinding.ActivityUidBinding

class ActivityUID : AppCompatActivity() {

    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var checkBox3: CheckBox
    private lateinit var numberKilosTextView: TextView

    private var totalWeight = 0
    private val view : ActivityUidBinding by lazy {
        ActivityUidBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        val clientName = intent.getStringExtra("clientName")
        view.clientName.text = clientName
        checkBox1 = findViewById(R.id.checkBox)
        checkBox2 = findViewById(R.id.checkBox2)
        checkBox3 = findViewById(R.id.checkBox3)
        numberKilosTextView = findViewById(R.id.numberKilos)

        // Set up the CheckBox objects to update the total weight and the TextView when checked/unchecked
        checkBox1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                totalWeight += 40
            } else {
                totalWeight -= 40
            }
            numberKilosTextView.text = totalWeight.toString()
        }

        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                totalWeight += 10
            } else {
                totalWeight -= 10
            }
            numberKilosTextView.text = totalWeight.toString()
        }

        checkBox3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                totalWeight += 20
            } else {
                totalWeight -= 20
            }
            numberKilosTextView.text = totalWeight.toString()
        }
    }
}