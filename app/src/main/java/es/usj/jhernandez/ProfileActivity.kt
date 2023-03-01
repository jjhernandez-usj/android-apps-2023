package es.usj.jhernandez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import es.usj.jhernandez.databinding.ActivityMainBinding
import es.usj.jhernandez.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private val binding : ActivityProfileBinding by lazy {
        ActivityProfileBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.tvPhone.setOnClickListener{
            Toast.makeText(this,"hola", Toast.LENGTH_SHORT).show()
        }
    }
}