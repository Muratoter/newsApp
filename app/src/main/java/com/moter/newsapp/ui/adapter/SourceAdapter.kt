package com.moter.newsapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moter.newsapp.R
import com.moter.newsapp.databinding.ItemSourceBinding
import com.moter.newsapp.model.Source

/**
 * Created by moter on 17.06.2019.
 */
class SourceAdapter(private val sourceList: List<Source>, private val ctx: Context, private val listener: Listener) :
    RecyclerView.Adapter<SourceAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(ctx).inflate(R.layout.item_source, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return sourceList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(sourceList[position], listener)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemSourceBinding.bind(itemView)
        fun bindItems(source: Source, listener: Listener) {
            binding.source = source
            binding.itemSource.setOnClickListener {
                listener.onClick(source)
            }

        }
    }

    interface Listener {
        fun onClick(source: Source)
    }

}