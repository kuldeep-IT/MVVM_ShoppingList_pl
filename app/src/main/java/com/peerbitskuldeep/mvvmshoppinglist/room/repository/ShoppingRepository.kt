package com.peerbitskuldeep.mvvmshoppinglist.room.repository

import com.peerbitskuldeep.mvvmshoppinglist.room.ShoppingDatabase
import com.peerbitskuldeep.mvvmshoppinglist.room.ShoppingItem

class ShoppingRepository(private val db: ShoppingDatabase) {

    suspend fun upsert(item: ShoppingItem)  = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItem()

}