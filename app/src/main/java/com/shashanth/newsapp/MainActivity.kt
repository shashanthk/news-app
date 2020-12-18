package com.shashanth.newsapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shashanth.newsapp.data.api.Status
import com.shashanth.newsapp.ui.news.NewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private val newsViewModel: NewsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsViewModel.newsList.observe(this, { data ->
            when (data.status) {
                Status.LOADING -> {
                    Toast.makeText(this@MainActivity, "Loading...", Toast.LENGTH_LONG).show()
                }
                Status.SUCCESS -> {
                    Log.i(TAG, data.data!!.size.toString())
                }
                Status.ERROR -> {
                    Toast.makeText(this@MainActivity, data.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

}