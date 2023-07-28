package com.example.kabaddi.network

import com.example.kabaddi.model.ProductsResponse
import retrofit2.http.GET

interface APIService {

    @GET("products")
    suspend fun getProductsResponse(): ProductsResponse
}
