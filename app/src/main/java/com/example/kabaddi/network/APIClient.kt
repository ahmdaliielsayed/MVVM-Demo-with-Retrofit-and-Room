package com.example.kabaddi.network

import com.example.kabaddi.model.ProductsResponse

object APIClient : RemoteDataSource {

    override suspend fun getProductsResponse(): ProductsResponse {
        return BaseRetrofitHelper.retrofit.create(APIService::class.java).getProductsResponse()
    }
}
