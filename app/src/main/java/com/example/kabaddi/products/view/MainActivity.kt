package com.example.kabaddi.products.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kabaddi.R
import com.example.kabaddi.local.LocalDataSourceImpl
import com.example.kabaddi.model.Product
import com.example.kabaddi.network.APIClient
import com.example.kabaddi.products.repo.ProductsRepositoryImpl
import com.example.kabaddi.products.viewmodel.ProductsViewModel
import com.example.kabaddi.products.viewmodel.ProductsViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ProductsViewModel
    lateinit var listProducts: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        viewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)
        gettingViewModelReady()

        viewModel.getListOfProducts()
        viewModel.listOfProducts.observe(this) { products ->
            Log.d("asd -> ", "onCreate: $products")
            if (!products.isNullOrEmpty()) {
                listProducts = products
            }
        }
    }

    private fun gettingViewModelReady() {
        val productsFactory = ProductsViewModelFactory(
            ProductsRepositoryImpl(APIClient, LocalDataSourceImpl(applicationContext))
        )
        viewModel = ViewModelProvider(this, productsFactory).get(ProductsViewModel::class.java)
    }
}
