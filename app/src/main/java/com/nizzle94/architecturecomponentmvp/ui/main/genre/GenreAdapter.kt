package com.nizzle94.architecturecomponentmvp.ui.main.genre

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.architecturecomponentmvp.databinding.GenreItemBinding
import com.nizzle94.data.entity.Genre

/**
 * Created by Khajiev Nizomjon on 06/06/2018.
 */
class GenreAdapter(
        private val context: Context,
        private val itemClickListener: (Genre) -> Unit
) : RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    private var items: ArrayList<Genre>? = ArrayList()

    fun addItems(genreList: ArrayList<Genre>) {
        if (items != null) {
            items!!.clear()
            items!!.addAll(genreList)
        } else {
            items = genreList
        }
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: GenreItemBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.genre_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items!![position], itemClickListener)
    }


    class ViewHolder(private val genreItemBinding: GenreItemBinding) :
            RecyclerView.ViewHolder(genreItemBinding.root) {
        fun bind(genre: Genre, clickListener: (Genre) -> Unit) {
            genreItemBinding.vm = genre
            genreItemBinding.root.setOnClickListener {
                clickListener(genre)
            }
        }
    }

}