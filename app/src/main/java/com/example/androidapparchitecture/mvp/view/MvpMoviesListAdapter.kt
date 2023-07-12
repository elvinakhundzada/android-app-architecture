package com.example.androidapparchitecture.mvp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidapparchitecture.R
import com.example.androidapparchitecture.databinding.MovieListItemLayoutBinding
import com.example.androidapparchitecture.mvp.model.MvpMovie

class MvpMoviesListAdapter(private val context: Context): RecyclerView.Adapter<MvpMoviesListAdapter.MovieViewHolder>() {

    private var movieList: ArrayList<MvpMovie> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       val itemView = LayoutInflater.from(context).inflate(R.layout.movie_list_item_layout, parent, false)

        return MovieViewHolder(itemView)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    fun setMovies(movieList: List<MvpMovie>) {
        this.movieList.clear()
        this.movieList.addAll(movieList)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private lateinit var binding: MovieListItemLayoutBinding

        fun bind(movie: MvpMovie) {
            binding = MovieListItemLayoutBinding.bind(itemView)

            Glide.with(itemView).load(movie.imagePath).into(binding.ivMoviePoster)
            binding.tvMovieTitle.text = movie.title
            binding.tvMovieRating.text = movie.rating.toString()
        }
    }
}