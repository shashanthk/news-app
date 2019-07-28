package in.shashanth;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class AppInstance extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
    }
}
