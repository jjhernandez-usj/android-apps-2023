package es.usj.jhernandez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import es.usj.jhernandez.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val view: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val items = listOf("item1", "item2", "item3")
        super.onCreate(savedInstanceState)

        setContentView(view.root)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        view.listView.adapter = adapter

    }
}