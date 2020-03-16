package com.example.productsroomwithrecyclerview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productsroomwithrecyclerview.dao.ProductDao
import com.example.productsroomwithrecyclerview.database.ProductDatabase
import com.example.productsroomwithrecyclerview.entity.Product
import com.example.productsroomwithrecyclerview.repo.ProductRepo
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: ProductRepo
    val allProducts: LiveData<List<Product>>

    init {

        val productDao = ProductDatabase.getDatabase(application).getProductDao()
        repo = ProductRepo(productDao)
        allProducts = repo.allProducts

    }

    fun saveProduct(product: Product) = viewModelScope.launch {
        repo.saveProduct(product)
    }

}