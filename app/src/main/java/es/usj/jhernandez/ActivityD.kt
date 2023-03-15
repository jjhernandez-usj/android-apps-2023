package es.usj.jhernandez

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.usj.jhernandez.databinding.ActivityDBinding

const val KEY = "RESULT_VALUE"
class ActivityD : AppCompatActivity() {

    private val view : ActivityDBinding by lazy {
        ActivityDBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btnFinish.setOnClickListener {
            intent.putExtra(KEY, view.etInput.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}