package com.peerbitskuldeep.mvvmshoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.peerbitskuldeep.mvvmshoppinglist.adapters.RecAdapter
import com.peerbitskuldeep.mvvmshoppinglist.dialog.AddDialogListener
import com.peerbitskuldeep.mvvmshoppinglist.dialog.AppShoppingItemDialog
import com.peerbitskuldeep.mvvmshoppinglist.room.ShoppingDatabase
import com.peerbitskuldeep.mvvmshoppinglist.room.ShoppingItem
import com.peerbitskuldeep.mvvmshoppinglist.room.repository.ShoppingRepository
import com.peerbitskuldeep.mvvmshoppinglist.viewModel.ShoppingViewModel
import com.peerbitskuldeep.mvvmshoppinglist.viewModel.viewModelFactory.ShoppingViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val viewModelFactory = ShoppingViewModelFactory(repository)

        //we can't pass object of repository in ViewModelProviders so created viewModelFactory
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(ShoppingViewModel::class.java)

        val adapter = RecAdapter(emptyList(), viewModel)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.getAllShoppingList().observe(this, Observer {

            adapter.items = it
            adapter.notifyDataSetChanged()

        })


        fb.setOnClickListener {

            AppShoppingItemDialog(this, object : AddDialogListener {
                override fun onAddButtonClicked(item: ShoppingItem) {

                    viewModel.upsert(item)

                }
            }).show()

        }
    }
}