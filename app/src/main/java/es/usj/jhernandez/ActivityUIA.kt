package es.usj.jhernandez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import es.usj.jhernandez.databinding.ActivityUiaBinding

class ActivityUIA : AppCompatActivity() {

    private val view : ActivityUiaBinding by lazy {
        ActivityUiaBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.btnLogin.isEnabled = false
        view.etUsername.addTextChangedListener {
            userEmpty = it?.length == 0
            checkBtnEnabled()
        }

        view.etPassword.addTextChangedListener {
            passEmpty = it?.length == 0
            checkBtnEnabled()
        }

        view.btnLogin.setOnClickListener{
            correctLogin()
        }

    }

    private fun checkBtnEnabled() {
        view.btnLogin.isEnabled = areFieldCompleted()
    }

    private var userEmpty = true
    private var passEmpty = true
    private fun areFieldCompleted() : Boolean {
        return !userEmpty && !passEmpty
    }

    private fun correctLogin(){

        if(view.etUsername.text.toString()==view.etPassword.text.toString()){

            Toast.makeText(this, "Welcome ${view.etUsername.text}" , Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }

    }
}