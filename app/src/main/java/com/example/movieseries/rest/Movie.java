package com.example.movieseries.rest;

import com.example.movieseries.model.MovieModel;
import com.example.movieseries.model.TrandModel;
import com.example.movieseries.model.TvModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Movie {
    @GET("movie/popular")
    Call<MovieModel> getMovie(@Query("api_key") String api_key);
    @GET("tv/popular")
    Call<TvModel> getTv(@Query("api_key") String api_key);
    @GET("trending/all/day")
    Call<TrandModel> getTrending(@Query("api_key") String api_key);
}
