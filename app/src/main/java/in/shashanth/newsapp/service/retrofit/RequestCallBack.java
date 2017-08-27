package in.shashanth.newsapp.service.retrofit;

import android.support.annotation.NonNull;

import in.shashanth.newsapp.interfaces.RequestListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shashanth on 27/8/17.
 */

public class RequestCallBack<T> implements Callback<T> {

    private RequestListener<T> listener;

    public RequestCallBack(RequestListener<T> listener) {
        this.listener = listener;
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        listener.onSuccessResponse(response.body());
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        listener.onFailureResponse(t);
    }
}
