package com.example.aribhatt.quakereport.model.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by aribhatt on 26/11/17.
 */

@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule(Application application){
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return application;
    }
}
