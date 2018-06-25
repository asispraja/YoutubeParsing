package com.example.aashish.youtubeparsing;

import com.example.aashish.youtubeparsing.entities.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aashish on 23/05/2018.
 */

public interface RequestInterface {
    @GET("youtube/v3/playlistItems")
    Call<Example> getData(@Query("part") String part,
                          @Query("fields") String fields,
                          @Query("maxResults") String maxResults,
                          @Query("playlistId") String id,
                          @Query("key") String key);
}
