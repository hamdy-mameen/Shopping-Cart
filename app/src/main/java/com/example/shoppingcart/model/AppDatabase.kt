package com.example.shoppingcart.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cart::class],version = 1)
 abstract class AppDatabase : RoomDatabase() {
  abstract fun getCartDao():CartDao
  companion object{
   @Volatile
  private var instance : AppDatabase? =null
   private val lock =Any()
   operator fun invoke(context: Context) = instance ?: synchronized(lock){
     instance ?: createInstance(context).also { instance= it }
   }
   private fun createInstance(context:Context) =
    Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"ShoppingCartDB.db").build()

  }

}