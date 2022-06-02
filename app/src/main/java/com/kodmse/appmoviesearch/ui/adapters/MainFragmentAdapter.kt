package com.kodmse.appmoviesearch.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appmoviesearch.databinding.FragmentMainRecyclerItemBinding
import com.kodmse.appmoviesearch.domain.Movie
import com.kodmse.appmoviesearch.ui.main.MainFragment

class MainFragmentAdapter(private val itemClickListener: MainFragment.OnItemViewClickListener) :
    RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {
    private var movieData: List<Movie> = listOf()
    private lateinit var binding: FragmentMainRecyclerItemBinding

    @SuppressLint("NotifyDataSetChanged")
    fun setMovie(data: List<Movie>) {
        movieData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        binding = FragmentMainRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MainViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(movieData[position])
    }

    override fun getItemCount() = movieData.size

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie) = with(binding) {
            mainFragmentRecyclerItemTextView.text = movie.name
            root.setOnClickListener { itemClickListener.onItemViewClick(movie) }
        }
    }
}