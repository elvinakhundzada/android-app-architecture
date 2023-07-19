package com.example.androidapparchitecture.common.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidapparchitecture.R
import com.example.androidapparchitecture.common.ui.model.Movie
import com.example.androidapparchitecture.databinding.MovieListItemLayoutBinding

class MoviesListAdapter(private val context: Context): RecyclerView.Adapter<MoviesListAdapter.MovieViewHolder>() {

    private var movieList: ArrayList<Movie> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       val itemView = LayoutInflater.from(context).inflate(R.layout.movie_list_item_layout, parent, false)

        return MovieViewHolder(itemView)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    fun setMovies(movieList: List<Movie>) {
        this.movieList.clear()
        this.movieList.addAll(movieList)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private lateinit var binding: MovieListItemLayoutBinding

        fun bind(movie: Movie) {
            binding = MovieListItemLayoutBinding.bind(itemView)

            Glide.with(itemView).load(movie.imagePath).into(binding.ivMoviePoster)
            binding.tvMovieTitle.text = movie.title
            binding.tvMovieRating.text = movie.rating.toString()
        }
    }
}