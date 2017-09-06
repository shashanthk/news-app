package in.shashanth.newsapp.registration;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import in.shashanth.newsapp.R;

/**
 * Created by shashanth on 3/9/17.
 */

public class RegistrationActivity extends AppCompatActivity {

    private static final String TAG = RegistrationActivity.class.getSimpleName();

    private EditText editEmail, editPassword;
    private Button btnRegister;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onStart() {
        super.onStart();

        currentUser = firebaseAuth.getCurrentUser();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firebaseAuth = FirebaseAuth.getInstance();

        editEmail = findViewById(R.id.et_email_address);
        editPassword = findViewById(R.id.et_password);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        createAccount();
                    }
                }
        );
    }

    private void createAccount() {

        if (!isValid()) {
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(getEmail(), getPassword())
                .addOnCompleteListener(
                        RegistrationActivity.this,
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    displayConfirmation(firebaseAuth.getCurrentUser());
                                } else {
                                    displayConfirmation(null);
                                }
                            }
                        })
                .addOnFailureListener(
                RegistrationActivity.this,
                new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "onFailure: Error, ", e);
                        Toast.makeText(RegistrationActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void displayConfirmation(FirebaseUser currentUser) {
        if (currentUser != null) {
            Toast.makeText(RegistrationActivity.this, "User " + currentUser.getEmail(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(RegistrationActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    private String getEmail() {
        return editEmail.getText().toString();
    }

    private String getPassword() {
        return editPassword.getText().toString();
    }

    public boolean isValid() {

        if (TextUtils.isEmpty(getEmail())) {
            Toast.makeText(RegistrationActivity.this, "Please enter Email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(getPassword())) {
            Toast.makeText(RegistrationActivity.this, "Please enter Password", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
