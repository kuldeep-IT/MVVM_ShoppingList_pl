package com.peerbitskuldeep.mvvmshoppinglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.peerbitskuldeep.mvvmshoppinglist.R
import com.peerbitskuldeep.mvvmshoppinglist.room.ShoppingItem
import com.peerbitskuldeep.mvvmshoppinglist.viewModel.ShoppingViewModel
import kotlinx.android.synthetic.main.custom_rec.view.*

class RecAdapter(
    var items: List<ShoppingItem>,
    val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<RecAdapter.RecViewHolder>() {

    inner class RecViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_rec, parent, false)
        return RecViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecViewHolder, position: Int) {

        var currentPositionItem = items[position]

        holder.itemView.apply {

            tvName_rec.text = currentPositionItem.name
            tvAmount_rec.text = "${currentPositionItem.amount}"

            delete_rec.setOnClickListener {
                viewModel.delete(currentPositionItem)

                Toast.makeText(it.context, "Data Deleted of ${currentPositionItem.name}", Toast.LENGTH_SHORT).show()
            }

            add_rec.setOnClickListener {
                currentPositionItem.amount++
                viewModel.upsert(currentPositionItem)
            }

            minus_rec.setOnClickListener {
                if (currentPositionItem.amount > 0) {
                    currentPositionItem.amount--
                    viewModel.upsert(currentPositionItem)
                }
            }

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }


}