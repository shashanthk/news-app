package in.shashanth.di;

import android.app.Application;
import android.util.Log;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import in.shashanth.BuildConfig;
import in.shashanth.api.ApiConstants;
import in.shashanth.api.NewsApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Singleton
    @Provides
    static HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> {
            Log.i("http", message);
        });

        if (BuildConfig.DEBUG) {
            interceptor.level(HttpLoggingInterceptor.Level.BODY);
        }

        return interceptor;
    }

    @Singleton
    @Provides
    static OkHttpClient providesHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .build();
    }

    @Singleton
    @Provides
    static Retrofit providesRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    static NewsApi providesNewsApi(Retrofit retrofit) {
        return retrofit.create(NewsApi.class);
    }

    @Singleton
    @Provides
    static Picasso providesPicasso(Application application) {
        return new Picasso.Builder(application)
                .build();
    }
}
