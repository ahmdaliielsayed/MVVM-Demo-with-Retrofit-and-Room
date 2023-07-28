package com.example.kabaddi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey
    val id: Int,
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
//    val images: List<String>,
    val price: Int,
    val rating: Double,
    val stock: Int,
    @ColumnInfo(name = "image_product")
    val thumbnail: String,
    val title: String
)
