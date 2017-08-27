package in.shashanth.newsapp.service;

import java.util.List;

import in.shashanth.newsapp.models.NewsModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by shashanth on 25/8/17.
 */

public interface NewsService {

    @GET("")
    void listNews(@Path("") String path, Call<List<NewsModel>> callBack);
}
