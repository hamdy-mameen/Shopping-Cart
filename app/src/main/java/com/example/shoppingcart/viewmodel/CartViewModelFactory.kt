package com.example.shoppingcart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingcart.repository.ShoppingRepositoryImp
@Suppress("UNCHECKED_CAST")
class CartViewModelFactory(val repositoryImp: ShoppingRepositoryImp):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CartViewModel(repositoryImp) as T
    }
}