package in.shashanth.newsapp.login;

/**
 * Created by shashanth on 4/9/17.
 */

public interface LoginPresenter {
    void loginWithEmailAndPassword(String email, String password);
    void loginWithGmail();
    void onDestroy();
}
