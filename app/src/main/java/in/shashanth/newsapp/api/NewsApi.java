package in.shashanth.newsapp.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("top-headlines")
    Call<ResponseBody> topHedLines(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );

}
