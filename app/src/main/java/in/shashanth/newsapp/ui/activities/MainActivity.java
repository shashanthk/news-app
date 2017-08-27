package in.shashanth.newsapp.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import in.shashanth.newsapp.R;
import in.shashanth.newsapp.interfaces.SourceView;
import in.shashanth.newsapp.models.Source;
import in.shashanth.newsapp.presenters.SourcesPresenter;
import in.shashanth.newsapp.service.retrofit.RetrofitManager;
import in.shashanth.newsapp.util.ui.UIHandlers;

/**
 * Created by shashanth on 25/8/17.
 */

public class MainActivity extends AppCompatActivity implements SourceView {

    private static final String TAG = "MainActivity";

    private Button btnGet;

    private SourcesPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGet = findViewById(R.id.button);

        btnGet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        presenter.getSourcesList();
                    }
                }
        );

        presenter = new SourcesPresenter(MainActivity.this, new RetrofitManager());
    }

    @Override
    public void showSources(List<Source> sourceList) {
        if (sourceList != null && sourceList.size() > 0)
            Toast.makeText(MainActivity.this, "Size is " + sourceList.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAlertMessage(String message) {
        UIHandlers.showSimpleAlertWithMessage(MainActivity.this, "Message", message);
    }

    @Override
    public void showProgressDialog(String message) {
        UIHandlers.showProgressDialog(MainActivity.this, message);
    }

    @Override
    public void hideProgressDialog() {
        UIHandlers.hideProgressDialog(MainActivity.this);
    }
}
