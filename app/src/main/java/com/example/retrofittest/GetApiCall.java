package com.example.retrofittest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetApiCall {
    // TODO:  1- add request method GET POST
    @GET("posts")
    Call<ResponseBody> getPosts();

    @GET("users/{username}/repos")
    Call<ResponseBody> getRepo(@Path("username") String userName);

    //https://newsapi.org/v2/top-headlines?country=eg&apiKey=e575345faedb4747abcd7742bf68dee0

    @GET("top-headlines")
    Call<ResponseBody>getNews(@Query("country")String country,@Query("apiKey")String apiKey);
}
