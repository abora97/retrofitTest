package com.example.retrofittest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetApiCall {
    // TODO:  1- add request method GET POST
    @GET("posts")
    Call<ResponseBody> getPosts();

    @GET("users/{username}/repos")
    Call<ResponseBody> getRepo(@Path("username") String userName);

}
