package com.peerbitskuldeep.mvvmshoppinglist.dialog

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.peerbitskuldeep.mvvmshoppinglist.R
import com.peerbitskuldeep.mvvmshoppinglist.room.ShoppingItem
import kotlinx.android.synthetic.main.add_shopping_alert_dialog.*

class AppShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.add_shopping_alert_dialog)

        tvAdd_dialog.setOnClickListener {

            val name = edtName_dialog.text.toString()
            val amount = edtAmount_dialog.text.toString()

            if (name.isEmpty() || amount.isEmpty())
            {
                Toast.makeText(context,"Please fill the data!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            Toast.makeText(context, "Successfully added $name!", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        tvCancel_dialog.setOnClickListener {

            cancel()

        }
    }

}