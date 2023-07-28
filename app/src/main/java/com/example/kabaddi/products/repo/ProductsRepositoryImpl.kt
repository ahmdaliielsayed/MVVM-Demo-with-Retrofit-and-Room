package com.example.kabaddi.products.repo

import androidx.lifecycle.LiveData
import com.example.kabaddi.local.LocalDataSource
import com.example.kabaddi.model.Product
import com.example.kabaddi.model.ProductsResponse
import com.example.kabaddi.network.RemoteDataSource

class ProductsRepositoryImpl(val remoteDataSource: RemoteDataSource, val localSource: LocalDataSource) : ProductsRepository {

    override suspend fun getRemoteProducts(): ProductsResponse {
        return remoteDataSource.getProductsResponse()
    }

    override suspend fun selectLocalProducts(): LiveData<List<Product>> {
        return localSource.selectLocalProducts()
    }

    override suspend fun insertLocalProduct(product: Product) {
        localSource.insertLocalProduct(product)
    }
}
