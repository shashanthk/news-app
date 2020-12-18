package com.shashanth.newsapp.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shashanth.newsapp.data.api.IDResponse
import com.shashanth.newsapp.data.api.Resource
import com.shashanth.newsapp.data.model.News
import com.shashanth.newsapp.data.repository.ApiRepository

class NewsViewModel(private val apiRepository: ApiRepository) : ViewModel() {

    private val _newsList = MutableLiveData<Resource<List<News>>>()
    val newsList: LiveData<Resource<List<News>>> = _newsList

    init {
        fetchNews()
    }

    private fun fetchNews() {

        _newsList.postValue(Resource.loading(null))

        apiRepository.getNews(object : IDResponse<MutableList<News>> {
            override fun onSuccess(data: MutableList<News>?) {
                _newsList.postValue(Resource.success(data))
            }

            override fun onError(error: String) {
                _newsList.postValue(Resource.error(error))
            }
        })
    }

}