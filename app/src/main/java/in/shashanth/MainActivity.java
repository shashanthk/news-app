package in.shashanth;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    private static final String TAG = "MainActivity";

    @Inject
    Picasso picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picasso.load(R.mipmap.ic_launcher).into((ImageView) findViewById(R.id.image));
    }
}
