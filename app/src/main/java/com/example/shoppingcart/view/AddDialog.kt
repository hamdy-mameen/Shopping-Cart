package com.example.shoppingcart.view

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import androidx.core.app.DialogCompat
import com.example.shoppingcart.R
import com.example.shoppingcart.model.Cart
import kotlinx.android.synthetic.main.add_item_dialog.*

class AddDialog(context:Context,var dialogInterface: DialogInterface):AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item_dialog)
        dialog_add.setOnClickListener {
            val item = name_input.text.toString()
            val quantity = quantity_input.text.toString()
            if(item.isEmpty() || quantity.isEmpty()){
                Toast.makeText(context,"please add items and quantity",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            dialogInterface.onAddClicked(Cart(item,quantity.toInt()))
            dismiss()
        }
        dialog_cancel.setOnClickListener { 
            cancel()
        }
    }
}