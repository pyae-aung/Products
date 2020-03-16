package com.example.productsroomwithrecyclerview.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.productsroomwithrecyclerview.entity.Product

@Dao
interface ProductDao {
    @Insert
    suspend fun saveProduct(product: Product)

    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<Product>>
}