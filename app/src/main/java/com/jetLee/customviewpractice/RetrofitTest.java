package com.jetLee.customviewpractice;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Description：
 * Author：Jet啟思
 * Time：2018/8/1 22:11
 */
public class RetrofitTest {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build();

    GitHubService service = retrofit.create(GitHubService.class);

    Call<List<GitHubService.Repo>> repos = service.listRepos("octocat");

    private void test() {

        repos.enqueue(new Callback<List<GitHubService.Repo>>() {
            @Override
            public void onResponse(Call<List<GitHubService.Repo>> call, Response<List<GitHubService.Repo>> response) {

            }

            @Override
            public void onFailure(Call<List<GitHubService.Repo>> call, Throwable t) {

            }
        });
    }


}


