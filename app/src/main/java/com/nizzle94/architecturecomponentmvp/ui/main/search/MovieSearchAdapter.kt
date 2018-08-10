package com.nizzle94.architecturecomponentmvp.ui.main.search

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nizzle94.architecturecomponentmvp.R
import com.nizzle94.architecturecomponentmvp.databinding.MovieItemBinding
import com.nizzle94.architecturecomponentmvp.databinding.SearchItemBinding
import com.nizzle94.architecturecomponentmvp.ui.main.movies.MoviesAdapter
import com.nizzle94.data.entity.Movie

/**
 * Created by Khajiev Nizomjon on 06/08/2018.
 */
class MovieSearchAdapter(private val context: Context, private val clickListener: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieSearchAdapter.ViewHolder>() {

    private var items: ArrayList<Movie>? = ArrayList()

    fun addItems(movieList: ArrayList<Movie>) {
        if (items != null) {
            items!!.clear()
            items!!.addAll(movieList)
        } else {
            items = movieList
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: SearchItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.search_item, parent, false)
        return MovieSearchAdapter.ViewHolder(binding)
    }


    override fun getItemCount(): Int = items!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items!![position], clickListener)
    }


    class ViewHolder(private val itemSearchItemBinding: SearchItemBinding) :
        RecyclerView.ViewHolder(itemSearchItemBinding.root) {

        fun bind(movie: Movie, clickListener: (Movie) -> Unit) {
            itemSearchItemBinding.vm = movie
            itemSearchItemBinding.root.setOnClickListener {
                clickListener(movie)
            }
        }
    }

    fun clear() {
        if (items != null) {
            items!!.clear()
        }
        notifyDataSetChanged()
    }
}