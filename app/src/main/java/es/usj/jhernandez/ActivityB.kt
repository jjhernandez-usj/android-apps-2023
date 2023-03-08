package es.usj.jhernandez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.usj.jhernandez.databinding.ActivityBBinding
import es.usj.jhernandez.databinding.ActivityaBinding

class ActivityB : AppCompatActivity() {
    private val binding : ActivityBBinding by lazy {
        ActivityBBinding.inflate(layoutInflater)
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btntoA.setOnClickListener{
            val intent = Intent(this, ActivityA::class.java)
            startActivity(intent)
        }
        binding.btntoD.setOnClickListener{
            val intent = Intent(this, ActivityD::class.java)
            startActivity(intent)
        }

}