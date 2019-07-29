package in.shashanth.newsapp;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import in.shashanth.newsapp.di.DaggerAppComponent;

public class BaseApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
