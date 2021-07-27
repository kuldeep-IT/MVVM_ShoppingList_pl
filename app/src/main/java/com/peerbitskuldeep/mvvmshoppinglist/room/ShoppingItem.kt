package com.peerbitskuldeep.mvvmshoppinglist.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.temporal.TemporalAmount

@Entity(tableName = "shopping_table")
data class ShoppingItem(

    @ColumnInfo(name = "item_name")
    var name: String,

    @ColumnInfo(name = "item_amount")
    var amount: Int
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}