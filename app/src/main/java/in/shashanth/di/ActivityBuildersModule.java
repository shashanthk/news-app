package in.shashanth.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import in.shashanth.MainActivity;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}
