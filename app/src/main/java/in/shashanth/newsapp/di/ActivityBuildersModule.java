package in.shashanth.newsapp.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import in.shashanth.newsapp.MainActivity;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}
