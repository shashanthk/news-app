package in.shashanth.newsapp.login;

/**
 * Created by shashanth on 4/9/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl(LoginPresenterImpl.this);
    }

    @Override
    public void loginWithEmailAndPassword(String email, String password) {
        if (loginView != null) {
            loginView.showProgress();
            loginInteractor.loginWithEmailAndPassword(email, password);
        }
    }

    @Override
    public void loginWithGmail() {
        if (loginView != null) {
            loginView.showProgress();
            loginInteractor.loginWithGmail();
        }
    }

    @Override
    public void onDestroy() {
        if (loginView != null) {
            loginView = null;
        }
    }

    @Override
    public void invalidEmail() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.invalidEmailId();
        }
    }

    @Override
    public void inValidPassword() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.invalidPassword();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.onSuccess();
        }
    }

    @Override
    public void onFailure(String message) {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.onFailure(message);
        }
    }
}
