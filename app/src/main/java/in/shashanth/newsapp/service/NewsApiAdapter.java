package in.shashanth.newsapp.service;

import retrofit2.Retrofit;

/**
 * Created by shashanth on 25/8/17.
 */

public class NewsApiAdapter {

    private static Retrofit retrofit = null;

    public static NewsService getApiClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.API_BASE_URL)
                    .build();
        }
        return retrofit.create(NewsService.class);
    }

}
