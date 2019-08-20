package com.example.org.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.org.coderswag.Adapters.CategoryAdapter
import com.example.org.coderswag.Model.Category
import com.example.org.coderswag.R
import com.example.org.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //lateinit var adapter: ArrayAdapter<Category>
    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        adapter = ArrayAdapter(
//                this,
//        android.R.layout.simple_list_item_1,
//        DataService.categories
//        )
        adapter = CategoryAdapter(this, DataService.categories)

        categoryListView.adapter = adapter

        categoryListView.setOnItemClickListener { adapterView, view, i, l ->
            val category = DataService.categories[i]
            Toast.makeText(this, "You clicked the ${category.title} cell", Toast.LENGTH_SHORT).show()
        }
    }
}
