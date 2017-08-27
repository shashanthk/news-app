package in.shashanth.newsapp.interfaces;

/**
 * Created by shashanth on 27/8/17.
 */

public interface RequestListener<T> {
    void onSuccessResponse(T t);
    void onFailureResponse(Throwable t);
}
