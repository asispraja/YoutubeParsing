package com.example.aashish.youtubeparsing;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aashish on 23/05/2018.
 */

public class Apliclient {
    private  static final String BASE_URL="https://www.googleapis.com/";
    private static Retrofit retrofit;
    public static Retrofit getClient(){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory
                            .create()).build();
            return retrofit;
    }
}
