package com.peerbitskuldeep.mvvmshoppinglist.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_table")
    fun getAllShoppingItem() : LiveData<List<ShoppingItem>>
}