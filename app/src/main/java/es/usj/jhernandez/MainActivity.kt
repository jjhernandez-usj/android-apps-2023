package es.usj.jhernandez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.usj.jhernandez.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}