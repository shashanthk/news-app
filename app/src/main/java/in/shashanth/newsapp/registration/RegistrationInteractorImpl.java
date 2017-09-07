package in.shashanth.newsapp.registration;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by shashanth on 6/9/17.
 */

public class RegistrationInteractorImpl implements RegistrationInteractor,
        OnCompleteListener<AuthResult>,
        OnFailureListener {

    private static final String TAG = RegistrationInteractorImpl.class.getSimpleName();

    private FirebaseAuth firebaseAuth;
    private OnRegistrationFinishedListener listener;

    public RegistrationInteractorImpl(OnRegistrationFinishedListener listener) {
        firebaseAuth = FirebaseAuth.getInstance();
        this.listener = listener;
    }

    @Override
    public void registerWithEmailAndPassword(String email, String password) {

        if (TextUtils.isEmpty(email)) {
            listener.invalidEmail();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            listener.invalidPassword();
            return;
        }

        if (password.length() < 6) {
            listener.invalidPassword();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegistrationInteractorImpl.this)
                .addOnFailureListener(RegistrationInteractorImpl.this);
    }

    @Override
    public void gotoLogin() {

    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            listener.onSuccess();
        } else {
            listener.onFailure("Something went wrong");
        }
    }

    @Override
    public void onFailure(@NonNull Exception e) {
        Log.e(TAG, "onFailure: Error, ", e);
        listener.onFailure(e.getMessage());
    }
}
