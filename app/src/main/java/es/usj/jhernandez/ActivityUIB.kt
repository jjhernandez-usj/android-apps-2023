package es.usj.jhernandez

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import es.usj.jhernandez.databinding.ActivityUibBinding

class ActivityUIB : AppCompatActivity() {

    private val view by lazy {
        ActivityUibBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.rbtnCitizen.setOnCheckedChangeListener { compoundButton, _ -> onRadioButtonClicked(compoundButton) }
        view.rbtncompany.setOnCheckedChangeListener { compoundButton, _ -> onRadioButtonClicked(compoundButton) }


        // Spinner config
        val spinner: Spinner = findViewById(view.spnrcountry.id);

        val values = resources.getStringArray(R.array.country_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, values)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        var selectedValue: String? = null

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, i: Int, l: Long) {
                selectedValue = adapterView?.getItemAtPosition(i).toString()
                Toast.makeText(applicationContext, selectedValue, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {
            }
        }
        // spinner config end

        view.rbtnCitizen.isChecked = true
        view.companyLayout.visibility = View.INVISIBLE
        view.rbtnCitizen.setOnCheckedChangeListener { _, _ ->
            view.citizenLayout.visibility = View.INVISIBLE
            view.companyLayout.visibility = View.VISIBLE
        }
        view.rbtncompany.setOnCheckedChangeListener { _, _ ->
            view.citizenLayout.visibility = View.VISIBLE
            view.companyLayout.visibility = View.INVISIBLE
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


}