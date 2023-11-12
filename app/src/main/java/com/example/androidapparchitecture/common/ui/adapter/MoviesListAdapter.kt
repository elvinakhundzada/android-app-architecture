package com.example.androidapparchitecture.common.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidapparchitecture.R
import com.example.androidapparchitecture.common.ui.model.MovieUiModel
import com.example.androidapparchitecture.databinding.MovieListItemLayoutBinding

class MoviesListAdapter(private val context: Context): RecyclerView.Adapter<MoviesListAdapter.MovieViewHolder>() {

    private var movieUiModelList: ArrayList<MovieUiModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       val itemView = LayoutInflater.from(context).inflate(R.layout.movie_list_item_layout, parent, false)

        return MovieViewHolder(itemView)
    }

    override fun getItemCount() = movieUiModelList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieUiModelList[position])
    }

    fun setMovies(movieUiModelList: List<MovieUiModel>) {
        this.movieUiModelList.clear()
        this.movieUiModelList.addAll(movieUiModelList)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private lateinit var binding: MovieListItemLayoutBinding

        fun bind(movieUiModel: MovieUiModel) {
            binding = MovieListItemLayoutBinding.bind(itemView)

            Glide.with(itemView).load(movieUiModel.poster).into(binding.ivMoviePoster)
            binding.tvMovieTitle.text = movieUiModel.title
            binding.tvMovieReleaseYear.text = movieUiModel.year
        }
    }
}