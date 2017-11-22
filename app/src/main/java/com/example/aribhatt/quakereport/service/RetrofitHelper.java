package com.example.aribhatt.quakereport.service;

import android.util.Log;

import com.example.aribhatt.quakereport.model.Quake;
import com.example.aribhatt.quakereport.model.Response;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aribhatt on 04/11/17.
 */

public class RetrofitHelper {
    Retrofit retrofit;

    public RetrofitHelper(String baseUrl){
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    public Observable<Response> getObservable(String format, String startTime, String endDate){
//        try {
            APIService apiService = this.retrofit.create(APIService.class);
            return apiService.getResponse(format, startTime, endDate);
//        }catch (Exception e){
//            Log.d("EXCPTN", e.toString());
//            return new Observable<Response>() {
//                @Override
//                protected void subscribeActual(Observer<? super Response> observer) {
//
//                }
//            };
//        }

    }
}
