package in.shashanth.newsapp.registration;

/**
 * Created by shashanth on 6/9/17.
 */

public interface RegistrationView {
    void showProgress();
    void hideProgress();
    void invalidEmailId();
    void invalidPassword();
    void onSuccess();
    void onFailure(String message);
}
