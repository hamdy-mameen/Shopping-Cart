package com.example.shoppingcart.viewmodel

import androidx.lifecycle.ViewModel
import com.example.shoppingcart.model.Cart
import com.example.shoppingcart.repository.ShoppingRepository
import com.example.shoppingcart.repository.ShoppingRepositoryImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(val repository: ShoppingRepositoryImp):ViewModel() {
    fun upsert(item:Cart) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }
    fun delete(item: Cart) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }
    fun getAllCartItems() = repository.getAllCartItems()
}