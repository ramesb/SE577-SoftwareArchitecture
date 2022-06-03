package com.boot.spring.jpa.h2.service;

import java.util.List;

import com.boot.spring.jpa.h2.model.GithubRepository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface RepositoryInterface {
	
	 @GET("user/repos")
	    Call<List<GithubRepository>> listRepos(@Header("Authorization") String accessToken,
	                                           @Header("Accept") String apiVersionSpec);
}
