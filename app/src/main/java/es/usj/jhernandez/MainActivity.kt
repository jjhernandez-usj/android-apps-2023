package es.usj.jhernandez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
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
        view.listView.onItemClickListener = object: AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MainActivity, " ", Toast.LENGTH_SHORT).show()
            }

        }
    }
}