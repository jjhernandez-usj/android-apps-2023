package es.usj.jhernandez

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import es.usj.jhernandez.databinding.ActivityCBinding
class ActivityC : AppCompatActivity() {

    private val binding : ActivityCBinding by lazy {
        ActivityCBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        binding.btnToCall.setOnClickListener{
            Toast.makeText(this,"hola", Toast.LENGTH_SHORT).show()
            call()

        }
        binding.btnToEmail.setOnClickListener{
            emailTo()
        }
        binding.button.setOnClickListener{
            val intent = Intent(this, ActivityA::class.java)
            startActivity(intent)
        }
    }
    fun call(){
        val uri= Uri.parse("tel:123456789")
        val intent= Intent(Intent.ACTION_DIAL,uri)
        startActivity(intent)
    }

    fun emailTo() {
        val email = "jjhernandez@usj.es"
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:$email")
        startActivity(intent)
    }

}