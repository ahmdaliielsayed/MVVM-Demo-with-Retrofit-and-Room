package com.example.kabaddi.products.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kabaddi.products.repo.ProductsRepository
import java.lang.IllegalArgumentException

class ProductsViewModelFactory(val productsRepository: ProductsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            ProductsViewModel(productsRepository) as T
        } else {
            throw IllegalArgumentException("ProductsViewModel class not found")
        }
    }
}
