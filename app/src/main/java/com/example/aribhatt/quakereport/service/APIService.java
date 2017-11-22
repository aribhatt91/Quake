package com.example.aribhatt.quakereport.service;

import com.example.aribhatt.quakereport.model.Quake;
import com.example.aribhatt.quakereport.model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aribhatt on 03/11/17.
 */

public interface APIService {
    @GET("fdsnws/event/1/query?")
    Observable<Response> getResponse(@Query("format") String format, @Query("starttime") String startTime, @Query("endtime") String endTime);
}
