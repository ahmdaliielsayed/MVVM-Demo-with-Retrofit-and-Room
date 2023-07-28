package com.example.kabaddi.local

import androidx.lifecycle.LiveData
import com.example.kabaddi.model.Product

interface LocalDataSource {

    suspend fun selectLocalProducts(): LiveData<List<Product>>
    suspend fun insertLocalProduct(product: Product)
}
