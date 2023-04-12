package es.usj.jhernandez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import es.usj.jhernandez.databinding.ActivityUiaBinding
import es.usj.jhernandez.databinding.ActivityUibBinding

class ActivityUIB : AppCompatActivity() {

    private val view : ActivityUibBinding by lazy {
        ActivityUibBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.rbtnCitizen.setOnCheckedChangeListener { compoundButton, _ -> onRadioButtonClicked(compoundButton) }
        view.rbtncompany.setOnCheckedChangeListener { compoundButton, _ -> onRadioButtonClicked(compoundButton) }
        view.btnInitCitizen.setOnClickListener{
            loginClient()
        }
    }

    private fun onRadioButtonClicked(view: View) {

        if (view is RadioButton ) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rbtnCitizen ->
                    if (checked) {
                        this.view.companyLayout.visibility = View.INVISIBLE
                        this.view.citizenLayout.visibility = View.VISIBLE
                    }
                R.id.rbtncompany ->
                    if (checked) {
                    this.view.citizenLayout.visibility = View.INVISIBLE
                        this.view.companyLayout.visibility = View.VISIBLE
                    }
            }
        }
    }
    private fun loginClient(){
        val firstName = view.tvFirstName.text.toString()
        val surname = view.tvSurname.text.toString()

        if(firstName.isNotEmpty() && surname.isNotEmpty()){
            val intent = Intent(this, ActivityUID::class.java).apply {
                putExtra("clientName", firstName)
            }
            startActivity(intent)
        } else{
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }


}