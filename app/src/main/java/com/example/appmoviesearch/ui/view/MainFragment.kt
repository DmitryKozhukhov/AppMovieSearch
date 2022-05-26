package com.example.appmoviesearch.ui.view

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.appmoviesearch.databinding.MainFragmentBinding
import com.example.appmoviesearch.model.Movie
import com.example.appmoviesearch.viewmodel.AppState
import com.example.appmoviesearch.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val observer = Observer<AppState> { renderData(it) }
        viewModel.liveData.observe(viewLifecycleOwner, observer)
        viewModel.getMovie()
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                val movieData = appState.movieData
                progressBar.visibility = View.GONE
                movieGroup.visibility = View.VISIBLE
                setData(movieData)
            }
            is AppState.Loading -> {
                progressBar.visibility = View.INVISIBLE
                movieGroup.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                progressBar.visibility = View.GONE
                movieGroup.visibility = View.INVISIBLE
                Snackbar
                    .make(mainView, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload") { viewModel.getMovie() }
                    .show()
            }
        }
    }

    private fun setData(movieData: Movie) = with(binding) {
        movieName.text = movieData.movie
        movieCountry.text = movieData.country
        movieYear.text = movieData.year.toString()
        movieRating.text = movieData.rating.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}