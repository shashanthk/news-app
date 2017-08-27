package in.shashanth.newsapp.service.retrofit;

import java.util.concurrent.TimeUnit;

import in.shashanth.newsapp.interfaces.RequestListener;
import in.shashanth.newsapp.interfaces.RestService;
import in.shashanth.newsapp.models.ArticlesWrapper;
import in.shashanth.newsapp.models.SourcesWrapper;
import in.shashanth.newsapp.service.RestConstants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shashanth on 25/8/17.
 */

public class RetrofitManager implements RestService {

    private final ApiService service;

    public RetrofitManager() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestConstants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        service = retrofit.create(ApiService.class);
    }

    @Override
    public void getSourcesList(RequestListener<SourcesWrapper> listener) {
        Call<SourcesWrapper> call = service.getNewsSources();
        call.enqueue(new RequestCallBack<>(listener));
    }

    @Override
    public void getArticlesList(String source, RequestListener<ArticlesWrapper> listener) {
        Call<ArticlesWrapper> call = service.getArticles(source, RestConstants.API_KEY);
        call.enqueue(new RequestCallBack<>(listener));
    }
}
