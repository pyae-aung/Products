package com.example.productsroomwithrecyclerview.repo

import androidx.lifecycle.LiveData
import com.example.productsroomwithrecyclerview.dao.ProductDao
import com.example.productsroomwithrecyclerview.entity.Product

class ProductRepo (private val productDao: ProductDao) {

    val allProducts: LiveData<List<Product>> = productDao.getAllProducts()

    suspend fun saveProduct(product: Product) {
        productDao.saveProduct(product)
    }
//
//    fun getAllProducts(): LiveData<List<Product>> {
//        val allProducts: LiveData<List<Product>> = productDao.getAllProducts()
//        return allProducts
//    }


}