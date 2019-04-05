package com.huxley.newyorktimes.client;

import com.huxley.newyorktimes.models.ApiResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

//all web services here
public interface Services {
    @GET("")
    Observable<ApiResponse> getAllNews(@Url String period, @Query("api-key") String apiKey);
}
