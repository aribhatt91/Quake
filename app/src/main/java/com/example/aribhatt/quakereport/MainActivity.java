package com.example.aribhatt.quakereport;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.aribhatt.quakereport.adapters.ListAdapter;
import com.example.aribhatt.quakereport.model.Quake;
import com.example.aribhatt.quakereport.model.Response;
import com.example.aribhatt.quakereport.service.RetrofitHelper;
import com.example.aribhatt.quakereport.view.ListItemDecorator;

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
    RecyclerView list;
    List<Quake> items;
    ListAdapter adapter;

    DisposableObserver<String> disposableObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);
        items = new ArrayList<Quake>();
        list = (RecyclerView) findViewById(R.id.list);
        adapter = new ListAdapter(MainActivity.this, items);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        list.addItemDecoration(new ListItemDecorator(1, 20, true));
        list.setItemAnimator(new DefaultItemAnimator());
        list.setLayoutManager(mLayoutManager);
        list.setAdapter(adapter);



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
                Log.d("QUAKE", response.toString());
                items.clear();
                items.addAll(response.getFeatures());
                //adapter.notifyDataSetChanged();

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("REQ", "Error found -- " + e.toString());

            }

            @Override
            public void onComplete() {
                Log.d("REQ", "Request complete");
                adapter.notifyDataSetChanged();
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
