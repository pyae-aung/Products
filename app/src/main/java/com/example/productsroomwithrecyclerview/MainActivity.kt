package com.example.productsroomwithrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.productsroomwithrecyclerview.adapter.ProductAdapter
import com.example.productsroomwithrecyclerview.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            var intent = Intent(this@MainActivity, AddActivity::class.java)
            startActivity(intent)
        }

        val productAdapter = ProductAdapter()
        recyclerProduct.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = productAdapter
        }



        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        productViewModel.allProducts.observe(this,
            Observer { products ->
                products?.let {
                    productAdapter.setProducts(it)
                }
            })

    }
}
