package com.example.shoppingcart.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class Cart(val item:String, var quantity:Int) {
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null


}