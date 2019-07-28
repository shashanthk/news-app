package in.shashanth.di;

import android.app.Application;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    static Picasso providesPicasso(Application application) {
        return new Picasso.Builder(application)
                .build();
    }
}
