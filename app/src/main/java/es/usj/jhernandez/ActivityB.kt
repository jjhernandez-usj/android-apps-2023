package es.usj.jhernandez

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import es.usj.jhernandez.databinding.ActivityBBinding
import es.usj.jhernandez.databinding.ActivityaBinding

class ActivityB : AppCompatActivity() {
    private val binding: ActivityBBinding by lazy {
        ActivityBBinding.inflate(layoutInflater)
    }

    private val contract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if(it.resultCode == Activity.RESULT_OK) {
            binding.textView.text = it.data?.extras?.getString(KEY, "No result")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btntoA.setOnClickListener {
            val intent = Intent(this, ActivityA::class.java)
            startActivity(intent)
        }
        binding.btntoD.setOnClickListener {
            val intent = Intent(this, ActivityD::class.java)
            contract.launch(intent)
        }
    }
}