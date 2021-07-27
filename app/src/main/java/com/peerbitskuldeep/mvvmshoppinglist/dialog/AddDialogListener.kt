package com.peerbitskuldeep.mvvmshoppinglist.dialog

import com.peerbitskuldeep.mvvmshoppinglist.room.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item: ShoppingItem)

}