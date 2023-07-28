package com.example.kabaddi.local

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.kabaddi.db.ProductDao
import com.example.kabaddi.db.ProductDatabase
import com.example.kabaddi.model.Product

class LocalDataSourceImpl(context: Context) : LocalDataSource {

    private lateinit var dao: ProductDao

    init {
        val db: ProductDatabase = ProductDatabase.getInstance(context)
        dao = db.productDao()
    }

    override suspend fun selectLocalProducts(): LiveData<List<Product>> {
        return dao.getAllLocalProducts()
    }

    override suspend fun insertLocalProduct(product: Product) {
        dao.insert(product)
    }
}
