package es.usj.jhernandez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
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


}