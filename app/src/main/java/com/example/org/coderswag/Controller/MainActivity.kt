package com.example.org.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.org.coderswag.Adapters.CategoryRecycleAdapter
import com.example.org.coderswag.R
import com.example.org.coderswag.Services.DataService
import com.example.org.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //lateinit var adapter: ArrayAdapter<Category>
    //lateinit var adapter: CategoryAdapter
    lateinit var adapter: CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        adapter = ArrayAdapter(
//                this,
//        android.R.layout.simple_list_item_1,
//        DataService.categories
//        )
        //adapter = CategoryAdapter(this, DataService.categories)
        adapter = CategoryRecycleAdapter(this, DataService.categories) {
            category ->
            val productsIntent = Intent(this, ProductsActivity::class.java)
            productsIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productsIntent)
        }

        categoryListView.adapter = adapter

//        categoryListView.setOnItemClickListener { adapterView, view, i, l ->
//            val category = DataService.categories[i]
//            Toast.makeText(this, "You clicked the ${category.title} cell", Toast.LENGTH_SHORT).show()
//        }

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)
    }
}
