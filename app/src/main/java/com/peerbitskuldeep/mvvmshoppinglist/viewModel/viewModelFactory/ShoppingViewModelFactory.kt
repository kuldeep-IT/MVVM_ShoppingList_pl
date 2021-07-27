package com.peerbitskuldeep.mvvmshoppinglist.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.peerbitskuldeep.mvvmshoppinglist.room.repository.ShoppingRepository
import com.peerbitskuldeep.mvvmshoppinglist.viewModel.ShoppingViewModel

@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(val repository: ShoppingRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }

}