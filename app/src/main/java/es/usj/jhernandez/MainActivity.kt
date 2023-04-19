package es.usj.jhernandez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        val items = mutableListOf("item1", "item2", "item3")
        super.onCreate(savedInstanceState)

        setContentView(view.root)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        view.listView.adapter = adapter
        view.listView.onItemClickListener = object: AdapterView.OnItemClickListener{
            override fun onItemClick(adapterView: AdapterView<*>?, view: View?, position: Int, p3: Long) {

                val selectedItem = adapter.getItem(position)
                Toast.makeText(this@MainActivity, selectedItem+" clicked", Toast.LENGTH_SHORT).show()
                items.remove(selectedItem)
                Log.e("list:", items.toString())
                adapter.notifyDataSetChanged()
            }


        }
        view.addbtn.setOnClickListener {
            items.add("item ${Math.random()}")
            adapter.notifyDataSetChanged()
        }
    }
}