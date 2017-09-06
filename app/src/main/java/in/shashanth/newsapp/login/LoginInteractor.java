package in.shashanth.newsapp.login;

/**
 * Created by shashanth on 4/9/17.
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener {
        void invalidEmail();
        void inValidPassword();
        void onSuccess();
        void onFailure(String message);
    }

    void loginWithEmailAndPassword(String email, String password);
    void loginWithGmail();
}
