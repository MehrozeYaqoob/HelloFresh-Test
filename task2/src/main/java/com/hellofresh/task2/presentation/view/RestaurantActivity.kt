package com.hellofresh.task2.presentation.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.hellofresh.task2.R
import com.hellofresh.task2.databinding.ActivityRestaurantBinding
import com.hellofresh.task2.presentation.adapter.RestaurantAdapter
import com.hellofresh.task2.presentation.model.BaseUiModel
import com.hellofresh.task2.presentation.model.DateUiModel
import com.hellofresh.task2.presentation.viewmodel.RestaurantViewModel
import com.hellofresh.task2.presentation.viewmodel.ViewModelFactory
import com.hellofresh.task2.utils.Status
import org.koin.android.ext.android.get
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
class RestaurantActivity : AppCompatActivity(), RestaurantView {

    private lateinit var binding: ActivityRestaurantBinding
    private lateinit var restaurantViewModel: RestaurantViewModel
    private lateinit var adapter: RestaurantAdapter

    private val dateToday: String by lazy {
        val sdf = SimpleDateFormat("dd MMM")
        sdf.format(Date())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onInitUI()
        onDefineViewModel()
        onObserveLiveData()
    }

    /* Init Recyclerview and set adapter with empty list*/
    private fun onInitUI() {
        val recyclerView = binding.restaurantRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RestaurantAdapter(arrayListOf(DateUiModel(dateToday)))
        recyclerView.adapter = adapter
    }

    /* Init ViewModel using ViewModel.Factory methods since, we are passing dependency to view model*/
    private fun onDefineViewModel() {
        restaurantViewModel = ViewModelProvider(
            this,
            get<ViewModelFactory>()
        )[RestaurantViewModel::class.java]
    }

    /* Lets observe for any event from view model and act accordingly*/
    private fun onObserveLiveData() {
        restaurantViewModel.recipeListLiveDataViewState.observe(
            this
        ) { response ->
            when (response.status) {
                Status.SUCCESS -> {
                    response.data?.let { recipes -> onAdapterItemAdded(recipes) }
                    hideLoading()
                }
                Status.LOADING -> {
                    showLoading()
                }
                Status.ERROR -> {
                    hideLoading()
                    showSnackBar(response.message ?: getString(R.string.unable_to_load_data))
                }
            }
        }
    }

    /* List of recipes are received from remote, lets pass it to adapter*/
    private fun onAdapterItemAdded(recipes: List<BaseUiModel>) {
        adapter.apply {
            addRecipes(recipes)
        }
    }

    /* Oops we have an error, lets notify user about it */
    override fun showSnackBar(msg: String) {
        Snackbar.make(binding.root, msg, Snackbar.LENGTH_LONG).show()
    }

    /* Content is being fetched from remote, lets show some loading */
    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.restaurantRecyclerView.visibility = View.GONE
    }

    /* Loading is stopped since we have received some response */
    override fun hideLoading() {
        binding.restaurantRecyclerView.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
    }
}
