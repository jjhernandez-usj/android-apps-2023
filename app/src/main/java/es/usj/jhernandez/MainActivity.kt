package es.usj.jhernandez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import es.usj.jhernandez.databinding.ActivityMainBinding
abstract class CustomAdapter<T>(private val items: MutableList<T>) : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): T {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}

data class Person(val name: String, val surname: String)

class MainActivity : AppCompatActivity() {

    private val view: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val items = mutableListOf(Person("Name", "Surname"))
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        val adapter = object: CustomAdapter<Person>(items) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val view = layoutInflater.inflate(R.layout.list_item_view, null)
                val tvName = view.findViewById<TextView>(R.id.tvName)
                val tvSurname = view.findViewById<TextView>(R.id.tvSurname)
                val item = getItem(position)
                tvName.text = item.name
                tvSurname.text = item.surname
                return view
            }

        }
        view.listView.adapter = adapter
        view.listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val selectedItem = adapter.getItem(position)
                Toast.makeText(this@MainActivity, "$selectedItem clicked", Toast.LENGTH_SHORT).show()
                items.remove(selectedItem)
                Log.e("list:", items.toString())
                adapter.notifyDataSetChanged()
            }
        view.addbtn.setOnClickListener {
            items.add(Person("Name ${Math.random()}", "Surname"))
            adapter.notifyDataSetChanged()
        }
    }
}