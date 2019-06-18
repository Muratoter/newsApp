package com.moter.newsapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moter.newsapp.R
import com.moter.newsapp.databinding.ItemNewsBinding
import com.moter.newsapp.model.Article
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * Created by moter on 18.06.2019.
 */
class NewsAdapter(private val newsList: List<Article>, private val ctx: Context, private val listener: Listener) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(ctx).inflate(R.layout.item_news, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(newsList[position], listener)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemNewsBinding.bind(itemView)

        fun bindItems(article: Article, listener: Listener) {
            binding.news=article

            itemView.newsItem.setOnClickListener {
                listener.onClick(article)
            }
        }
    }

    interface Listener {
        fun onClick(article: Article)
    }
}