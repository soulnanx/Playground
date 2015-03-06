package com.playground.renan.playground.rest;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by renan on 2/25/15.
 */
public interface GitHubService {

    @GET("/users/{user}/repos")
    List<Repo> listRepos(@Path("user") String user);
}
