package com.example.shoppingcart.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun upsert(item:Cart)
   @Delete
  suspend fun delete(item:Cart)
   @Query("SELECT * FROM cart_items")
   fun getAllCartItems():LiveData<List<Cart>>
}