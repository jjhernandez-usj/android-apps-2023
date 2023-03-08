package es.usj.jhernandez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import es.usj.jhernandez.databinding.ActivityProfileBinding
import es.usj.jhernandez.databinding.ActivityaBinding

class ActivityA : AppCompatActivity() {

    private val binding : ActivityaBinding by lazy {
        ActivityaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btntoB.setOnClickListener{
            val intent = Intent(this, ActivityB::class.java)
            startActivity(intent)
        }
        binding.btntoC.setOnClickListener{
            val intent = Intent(this, ActivityC::class.java)
            startActivity(intent)
        }

    }
}