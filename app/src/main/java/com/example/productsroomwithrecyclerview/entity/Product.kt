package com.example.productsroomwithrecyclerview.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
class Product (
    @PrimaryKey
    @ColumnInfo(name = "productId")
    var mId: Int,
    @ColumnInfo(name = "productName")
    var mName: String,
    @ColumnInfo(name = "price")
    var mPrice: Double,
    @ColumnInfo(name = "quantity")
    var mQuantity: Int
)