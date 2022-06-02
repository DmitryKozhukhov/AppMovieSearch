package com.kodmse.appmoviesearch.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.appmoviesearch.R
import com.example.appmoviesearch.databinding.MainFragmentBinding
import com.google.android.material.navigation.NavigationBarView
import com.kodmse.appmoviesearch.data.AppState
import com.kodmse.appmoviesearch.domain.Movie
import com.kodmse.appmoviesearch.showSnackBar
import com.kodmse.appmoviesearch.showSnackBarNotAction
import com.kodmse.appmoviesearch.ui.adapters.MainFragmentAdapter
import com.kodmse.appmoviesearch.ui.details.DetailsFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModel()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private var adapter: MainFragmentAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            mainFragmentRecyclerView.adapter = adapter

            val observer = Observer<AppState> { renderData(it) }
            viewModel.liveData.observe(viewLifecycleOwner, observer)
            viewModel.getMovieFromLocalSourceAll()

            bottomNav.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.action_list -> {
                        viewModel.getMovieFromLocalSourceAll()
                        mainFragment.showSnackBarNotAction(
                            getString(R.string.all_movies)
                        )
                        return@OnItemSelectedListener true
                    }

                    R.id.action_top -> {
                        viewModel.getMovieFromLocalSourceTop250()
                        mainFragment.showSnackBarNotAction(
                            getString(R.string.top_250_movies)
                        )
                        return@OnItemSelectedListener true
                    }
                }
                false
            })
        }
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {

                progressBar.visibility = View.GONE
                adapter = MainFragmentAdapter(object : OnItemViewClickListener {
                    override fun onItemViewClick(movie: Movie) {
                        val manager = activity?.supportFragmentManager
                        manager?.let { manager ->
                            val bundle = Bundle().apply {
                                putParcelable(DetailsFragment.BUNDLE_EXTRA, movie)
                            }
                            manager.beginTransaction()
                                .add(R.id.container, DetailsFragment.newInstance(bundle))
                                .addToBackStack("")
                                .commitAllowingStateLoss()
                        }
                    }
                }).apply {
                    setMovie(appState.movieData)
                }
                mainFragmentRecyclerView.adapter = adapter
            }
            is AppState.Loading -> {
                progressBar.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                progressBar.visibility = View.GONE
                mainFragment.showSnackBar(
                    R.string.error,
                    R.string.reload,
                    { viewModel.getMovieFromLocalSourceAll() })
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface OnItemViewClickListener {
        fun onItemViewClick(movie: Movie)
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}