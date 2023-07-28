package com.example.kabaddi.network

import com.example.kabaddi.model.ProductsResponse

interface RemoteDataSource {

    suspend fun getProductsResponse(): ProductsResponse
}
