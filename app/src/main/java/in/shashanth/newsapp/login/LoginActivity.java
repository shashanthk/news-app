package in.shashanth.newsapp.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import in.shashanth.newsapp.R;
import in.shashanth.newsapp.util.ui.UIHandlers;

/**
 * Created by shashanth on 2/9/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginView {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText editEmail, editPassword;
    private Button btnLogin;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenterImpl(LoginActivity.this);

        editEmail = findViewById(R.id.et_email_address);
        editPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        loginPresenter.loginWithEmailAndPassword(
                                editEmail.getText().toString(),
                                editPassword.getText().toString());
                    }
                }
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }

    @Override
    public void showProgress() {
        UIHandlers.showProgressDialog(LoginActivity.this, "Please wait...");
    }

    @Override
    public void hideProgress() {
        UIHandlers.hideProgressDialog(LoginActivity.this);
    }

    @Override
    public void invalidEmailId() {
        Toast.makeText(LoginActivity.this, "Invalid Email Id", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void invalidPassword() {
        Toast.makeText(LoginActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {
        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(String errorMessage) {
        Toast.makeText(LoginActivity.this, "Login Failed, " + errorMessage, Toast.LENGTH_LONG).show();
    }
}
