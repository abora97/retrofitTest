package com.example.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    String url = "https://jsonplaceholder.typicode.com/posts";
    String gitGubUrl = "https://api.github.com/users/abora97/";
    String gitHub = "https://api.github.com/";
    String baseUrl = "https://jsonplaceholder.typicode.com/";

    String news = "https://newsapi.org/v2/";
    String palceHolder = "https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text1);
        button = findViewById(R.id.bu_lode);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPlaceHolder(view);
            }
        });

    }


    public void loadSubject(View view) {
        // TODO:  2- add Retrofit Code
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).build();
        GetApiCall getSubject = retrofit.create(GetApiCall.class);
        // TODO: 3- you have 2 chose 1-execute() not handel call back 2-enqueue() can handel call back like this code
        getSubject.getPosts().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    textView.setText(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void getRepo(View view) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(gitHub).build();
        GetApiCall getApiCall = retrofit.create(GetApiCall.class);
        getApiCall.getRepo("abora97").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    textView.setText(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void getNews(View view) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(news).build();
        GetApiCall getApiCall = retrofit.create(GetApiCall.class);
        getApiCall.getNews("eg", "e575345faedb4747abcd7742bf68dee0").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    textView.setText(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    void getPlaceHolder(View view) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(palceHolder).build();
        GetApiCall getApiCall = retrofit.create(GetApiCall.class);
        getApiCall.getJsonPlaceHolder("mahmoud", "testPost", "1").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    textView.setText(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
