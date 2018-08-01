package com.jetLee.customviewpractice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Description：
 * Author：Jet啟思
 * Time：2018/8/1 22:31
 */
public interface GitHubService {

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

    class Repo {

    }

}
