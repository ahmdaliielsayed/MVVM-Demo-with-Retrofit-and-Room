package com.example.kabaddi.products.repo

import androidx.lifecycle.LiveData
import com.example.kabaddi.model.Product
import com.example.kabaddi.model.ProductsResponse

interface ProductsRepository {

    suspend fun getRemoteProducts(): ProductsResponse
    suspend fun selectLocalProducts(): LiveData<List<Product>>
    suspend fun insertLocalProduct(product: Product)
}
