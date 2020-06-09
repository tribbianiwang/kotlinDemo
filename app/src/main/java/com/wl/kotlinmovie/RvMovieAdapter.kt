package com.wl.kotlinmovie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wl.kotlinmovie.bean.TmdbMovie
import kotlinx.android.synthetic.main.layout_rv_movie_item.view.*

class RvMovieAdapter(movieBeans: MutableList<TmdbMovie>) :RecyclerView.Adapter<RvMovieAdapter.ViewHolder>() {
    var movieBeans: MutableList<TmdbMovie>
    init {
        this.movieBeans = movieBeans
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var contentView = LayoutInflater.from(parent.context).inflate(R.layout.layout_rv_movie_item,parent,false)
        return ViewHolder(contentView)

    }

    override fun getItemCount(): Int {

       return movieBeans.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.tv_title.text = movieBeans.get(position).title
        holder.itemView.tv_point.text = movieBeans.get(position).vote_average.toString()+"分"
    }
}