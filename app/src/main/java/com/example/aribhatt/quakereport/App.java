package com.example.aribhatt.quakereport;

import android.app.Application;

import com.example.aribhatt.quakereport.model.component.ApplicationComponent;
import com.example.aribhatt.quakereport.model.component.DaggerApplicationComponent;
import com.example.aribhatt.quakereport.model.module.ApplicationModule;

/**
 * Created by aribhatt on 26/11/17.
 */

public class App extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
