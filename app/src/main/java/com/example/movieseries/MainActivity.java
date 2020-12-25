package com.example.movieseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.movieseries.adapter.Movieadapter;
import com.example.movieseries.adapter.TrandAdapter;
import com.example.movieseries.adapter.Tvadapter;
import com.example.movieseries.helper.Constant;
import com.example.movieseries.model.MovieModel;
import com.example.movieseries.model.Result;
import com.example.movieseries.model.Result_trend;
import com.example.movieseries.model.TrandModel;
import com.example.movieseries.model.TvModel;
import com.example.movieseries.model.TvResult;
import com.example.movieseries.rest.ApiClint;
import com.example.movieseries.rest.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Movie movie;
    List<Result> resultList;
    List<TvResult> tvresultList;
    List<Result_trend> trandresultList;
    Movieadapter movieadapter;
    Tvadapter tvadapter;
    TrandAdapter trandAdapter;
    RecyclerView movieRecyV,seriseRecV,trandingRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        movieRecyV=findViewById(R.id.movieRe);
        seriseRecV=findViewById(R.id.seriseRe);
        trandingRec=findViewById(R.id.treandRe);
        movieRecyV.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        seriseRecV.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        trandingRec.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));

        getMoviesList();
        getSeriseList();
        getTranding();


    }

    private void getTranding() {
        movie=ApiClint.getClient().create(Movie.class);
        Call<TrandModel> call = movie.getTrending(Constant.API_KEY);
        call.enqueue(new Callback<TrandModel>() {
            @Override
            public void onResponse(Call<TrandModel> call, Response<TrandModel> response) {
                trandresultList = response.body().getResults();
//                Log.e("test case",response.body().getResults().get(0).getOriginalTitle());
                trandAdapter = new TrandAdapter(MainActivity.this,trandresultList);
                trandingRec.setAdapter(trandAdapter);
            }

            @Override
            public void onFailure(Call<TrandModel> call, Throwable t) {

            }
        });
    }

    private void getSeriseList() {
        movie=ApiClint.getClient().create(Movie.class);
        Call<TvModel> call = movie.getTv(Constant.API_KEY);
        call.enqueue(new Callback<TvModel>() {
            @Override
            public void onResponse(Call<TvModel> call, Response<TvModel> response) {
                tvresultList = response.body().getResults();
//                Log.e("test case",response.body().getResults().get(0).getOriginalTitle());
                tvadapter = new Tvadapter(MainActivity.this,tvresultList);
                seriseRecV.setAdapter(tvadapter);
            }

            @Override
            public void onFailure(Call<TvModel> call, Throwable t) {

            }
        });
    }

    private void getMoviesList() {
        movie=ApiClint.getClient().create(Movie.class);
        Call<MovieModel> call = movie.getMovie(Constant.API_KEY);
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                resultList = response.body().getResults();
                Log.e("test case",response.body().getResults().get(0).getOriginalTitle());
                movieadapter = new Movieadapter(MainActivity.this,resultList);
                movieRecyV.setAdapter(movieadapter);
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
    }


//    private void recyViewM() {
//        recyclerViewMovie=findViewById(R.id.movieID);
////        recyclerViewMovie.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
////        adapter=new Movieadapter(this,modelList);
////        recyclerViewMovie.setAdapter(adapter);
//
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//        recyclerViewMovie.setLayoutManager(manager);
//        recyclerViewMovie.setHasFixedSize(true);
//        adapter = new Movieadapter(this,modelList);
//        recyclerViewMovie.setAdapter(adapter);
//    }
}