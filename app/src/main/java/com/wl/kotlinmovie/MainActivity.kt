package com.wl.kotlinmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.wl.kotlinmovie.utils.TmdbViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var tmdbViewModel: TmdbViewModel
    var rvMovieAdapter:RvMovieAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies.layoutManager = LinearLayoutManager(this)


        tmdbViewModel = ViewModelProviders.of(this).get(TmdbViewModel::class.java)
        tmdbViewModel.fetchMovies()

        tmdbViewModel.popularMoviesLiveData.observe(this, Observer {

            rvMovieAdapter = RvMovieAdapter(it)
            rv_movies.adapter = rvMovieAdapter
        })





    }
}