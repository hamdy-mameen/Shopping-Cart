package com.example.shoppingcart.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.shoppingcart.model.AppDatabase
import com.example.shoppingcart.model.Cart

class ShoppingRepositoryImp(context: Context) : ShoppingRepository{
   private val db = AppDatabase(context)
    override suspend fun upsert(item: Cart) = db.getCartDao().upsert(item)

    override suspend fun delete(item: Cart) = db.getCartDao().delete(item)

    override fun getAllCartItems(): LiveData<List<Cart>> = db.getCartDao().getAllCartItems()
}