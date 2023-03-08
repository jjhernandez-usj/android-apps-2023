package es.usj.jhernandez

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import es.usj.jhernandez.databinding.ActivityManualCreatedBinding

class ManualCreatedActivity : AppCompatActivity() {

    private val view : ActivityManualCreatedBinding by lazy {
        ActivityManualCreatedBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(view.root)
        show("onCreate")
        view.button.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
    private fun show(method: String) {
        Log.v("METHOD", method)
        Toast.makeText(this, "Method $method called!!", Toast.LENGTH_SHORT).show()
    }
    override fun onStart() {
        super.onStart()
        show("onStart")
    }

    override fun onResume() {
        super.onResume()
        show("onResume")
    }

    override fun onPause() {
        super.onPause()
        show("onPause")
    }

    override fun onStop() {
        super.onStop()
        show("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        show("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        show("onDestroy")
    }
}