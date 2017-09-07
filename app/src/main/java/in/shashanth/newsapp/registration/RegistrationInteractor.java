package in.shashanth.newsapp.registration;

/**
 * Created by shashanth on 6/9/17.
 */

public interface RegistrationInteractor {

    interface OnRegistrationFinishedListener{
        void invalidEmail();
        void invalidPassword();
        void onSuccess();
        void onFailure(String message);
    }

    void registerWithEmailAndPassword(String email, String password);
    void gotoLogin();
}
