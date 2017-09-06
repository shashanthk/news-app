package in.shashanth.newsapp.service.retrofit;

import in.shashanth.newsapp.articles.ArticlesWrapper;
import in.shashanth.newsapp.source.SourcesWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shashanth on 25/8/17.
 */

public interface ApiService {

    @GET("v1/sources?language=en")
    Call<SourcesWrapper> getNewsSources();

    @GET("v1/articles")
    Call<ArticlesWrapper> getArticles(@Query("source") String source, @Query("apiKey") String apiKey);
}
