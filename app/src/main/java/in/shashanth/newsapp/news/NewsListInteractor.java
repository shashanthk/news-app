package in.shashanth.newsapp.news;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.List;

import in.shashanth.newsapp.models.NewsModel;
import in.shashanth.newsapp.service.NewsApiAdapter;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shashanth on 25/8/17.
 */

public class NewsListInteractor implements Call<List<NewsModel>> {

    private OnNewsInteractorFinishedListener listener;

    public NewsListInteractor(OnNewsInteractorFinishedListener listener) {
        this.listener = listener;
    }

    public void loadNews() {
        NewsApiAdapter.getApiClient().listNews("", NewsListInteractor.this);
    }


    @Override
    public Response<List<NewsModel>> execute() throws IOException {
        return null;
    }

    @Override
    public void enqueue(@NonNull Callback<List<NewsModel>> callback) {

    }

    @Override
    public boolean isExecuted() {
        return false;
    }

    @Override
    public void cancel() {

    }

    @Override
    public boolean isCanceled() {
        return false;
    }

    @Override
    public Call<List<NewsModel>> clone() {
        return null;
    }

    @Override
    public Request request() {
        return null;
    }
}
