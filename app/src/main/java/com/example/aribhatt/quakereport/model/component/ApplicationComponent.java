package com.example.aribhatt.quakereport.model.component;

import com.example.aribhatt.quakereport.MainActivity;
import com.example.aribhatt.quakereport.model.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by aribhatt on 26/11/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MainActivity activity);
}
