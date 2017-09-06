package in.shashanth.newsapp.login;

/**
 * Created by shashanth on 4/9/17.
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void invalidEmailId();
    void invalidPassword();
    void onSuccess();
    void onFailure(String errorMessage);
}
