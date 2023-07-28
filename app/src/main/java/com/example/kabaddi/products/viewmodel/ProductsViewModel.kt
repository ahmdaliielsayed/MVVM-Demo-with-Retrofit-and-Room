package com.example.kabaddi.products.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kabaddi.model.Product
import com.example.kabaddi.products.repo.ProductsRepository
import kotlinx.coroutines.launch

class ProductsViewModel(private val productsRepository: ProductsRepository) : ViewModel() {

    private val _listOfProducts = MutableLiveData<List<Product>>()
    val listOfProducts: LiveData<List<Product>> = _listOfProducts

    fun getListOfProducts() {
        viewModelScope.launch {
            val remoteProducts = productsRepository.getRemoteProducts()
            val productList = remoteProducts.products
            for (item in productList) {
                productsRepository.insertLocalProduct(item)
            }

            _listOfProducts.value = productList
        }
    }
}
