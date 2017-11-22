package com.example.aribhatt.quakereport;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.aribhatt.quakereport.model.Quake;
import com.example.aribhatt.quakereport.model.Response;
import com.example.aribhatt.quakereport.service.RetrofitHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    List<String> list = Arrays.asList(new String[]{"Hello", "World", "How", "are", "you?"});

    DisposableObserver<String> disposableObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Observable<String> observable = Observable.fromIterable(list);
//
//        disposableObserver = observable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableObserver<String>() {
//                    @Override
//                    public void onNext(@NonNull String s) {
//                        Log.d("RXOBSERVER", s);
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                }
//        );



        RetrofitHelper retrofitHelper = new RetrofitHelper("https://earthquake.usgs.gov");
        retrofitHelper.getObservable("geojson", "2014-01-01", "2014-01-02")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Response response) {
                Log.d("QUAKE", response.getFeatures().toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("REQ", "Error found -- " + e.toString());

            }

            @Override
            public void onComplete() {
                Log.d("REQ", "Request complete");

            }
        });
    }

    @Override
    protected void onDestroy() {
        if(disposableObserver != null && !disposableObserver.isDisposed()){
            disposableObserver.dispose();
        }
        super.onDestroy();
    }
}
