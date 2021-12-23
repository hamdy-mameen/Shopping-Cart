package com.example.shoppingcart.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingcart.R
import com.example.shoppingcart.model.Cart
import com.example.shoppingcart.viewmodel.CartViewModel
import kotlinx.android.synthetic.main.cart_items.view.*

class ShoppingCartAdapter(var items:List<Cart>,val viewModel: CartViewModel):
    RecyclerView.Adapter<ShoppingCartAdapter.CartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_items,parent,false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cart = items[position]
        holder.itemView.quantity_txt.text = "${cart.quantity}"
        holder.itemView.name_txt.text = cart.item
        holder.itemView.img_delete.setOnClickListener {
            viewModel.delete(cart)
        }
        holder.itemView.img_minus.setOnClickListener {
            if (cart.quantity>0){
                cart.quantity--
                viewModel.upsert(cart)
            }
        }
        holder.itemView.img_plus.setOnClickListener {
            cart.quantity++
            viewModel.upsert(cart)
        }
    }

    override fun getItemCount(): Int {
      return items.size
    }
   class CartViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView)
}