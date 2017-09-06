package in.shashanth.newsapp.login;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by shashanth on 4/9/17.
 */

public class LoginInteractorImpl implements LoginInteractor,
        OnCompleteListener<AuthResult>,
        OnFailureListener {

    private static final String TAG = LoginInteractorImpl.class.getSimpleName();

    private FirebaseAuth firebaseAuth;
    private OnLoginFinishedListener listener;

    public LoginInteractorImpl(OnLoginFinishedListener listener) {
        firebaseAuth = FirebaseAuth.getInstance();
        this.listener = listener;
    }

    @Override
    public void loginWithEmailAndPassword(String email, String password) {

        if (TextUtils.isEmpty(email)) {
            listener.invalidEmail();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            listener.inValidPassword();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginInteractorImpl.this)
                .addOnFailureListener(LoginInteractorImpl.this);

    }

    @Override
    public void loginWithGmail() {
        
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            listener.onSuccess();
        } else {
            listener.onFailure("Invalid Email/Password");
        }
    }

    @Override
    public void onFailure(@NonNull Exception e) {
        Log.e(TAG, "onFailure: Error, ", e);
        listener.onFailure(e.getMessage());
    }
}
