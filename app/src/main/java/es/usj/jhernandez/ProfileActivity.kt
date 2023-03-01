package es.usj.jhernandez

import android.content.Intent
import android.net.Uri
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
            call()

        }

        binding.tvEmail.setOnClickListener{
            emailTo()
        }

    }
    fun call(){
        val phone=binding.tvPhone.text
        val uri= Uri.parse("tel:$phone")
        val intent=Intent(Intent.ACTION_DIAL,uri)
        startActivity(intent)
    }

    fun emailTo(){
        val email=binding.tvEmail.text
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        startActivity(intent)
    }
}