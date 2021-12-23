package com.example.shoppingcart.repository

import androidx.lifecycle.LiveData
import com.example.shoppingcart.model.Cart

interface ShoppingRepository {
   suspend fun upsert(item:Cart)
   suspend fun delete(item: Cart)
    fun getAllCartItems():LiveData<List<Cart>>
}