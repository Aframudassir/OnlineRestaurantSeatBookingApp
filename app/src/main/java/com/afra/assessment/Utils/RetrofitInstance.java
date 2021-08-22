package com.afra.assessment.Utils;

import com.afra.assessment.Api.ApiBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.afra.assessment.Utils.Constants.BASE_URL;

public class RetrofitInstance {
    public static Retrofit retrofitInstance(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static ApiBuilder apiBuilder(){
        Retrofit retrofit = retrofitInstance();

        return retrofit.create(ApiBuilder.class);
    }

}
