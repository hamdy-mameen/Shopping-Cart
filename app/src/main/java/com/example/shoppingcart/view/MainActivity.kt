package com.example.shoppingcart.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingcart.R
import com.example.shoppingcart.model.Cart
import com.example.shoppingcart.repository.ShoppingRepositoryImp
import com.example.shoppingcart.viewmodel.CartViewModel
import com.example.shoppingcart.viewmodel.CartViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = ShoppingRepositoryImp(this)
        val factory = CartViewModelFactory(repository)
        val viewModel = ViewModelProvider(this,factory).get(CartViewModel::class.java)
        val adapter = ShoppingCartAdapter(listOf(),viewModel)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        viewModel.getAllCartItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
        add_to_cart.setOnClickListener {
            AddDialog(this,object : DialogInterface{
                override fun onAddClicked(item : Cart){
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}