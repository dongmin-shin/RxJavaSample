package com.example.dongminshin.sample.chapter8;

import com.example.dongminshin.sample.chapter8.models.stackexchange.UsersResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by DongMinShin on 16. 6. 1..
 */
public interface StackExchangeAPI {

    @GET("/2.2/users?order=desc&sort=reputation&site=stackoverflow")
    Observable<UsersResponse> getMostPopularSOusers(@Query("pagesize") int howMany);

}
