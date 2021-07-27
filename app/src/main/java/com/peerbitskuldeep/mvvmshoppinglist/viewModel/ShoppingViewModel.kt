package com.peerbitskuldeep.mvvmshoppinglist.viewModel

import androidx.lifecycle.ViewModel
import com.peerbitskuldeep.mvvmshoppinglist.room.ShoppingItem
import com.peerbitskuldeep.mvvmshoppinglist.room.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(val repository: ShoppingRepository) : ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {

        repository.upsert(item)

    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {

        repository.delete(item)

    }

    fun getAllShoppingList() = repository.getAllShoppingItems()

}