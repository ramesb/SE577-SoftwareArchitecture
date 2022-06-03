package com.boot.spring.jpa.h2.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.boot.spring.jpa.h2.model.GithubRepository;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

@Service
public class GithubService {
	
	@Value("${accessToken}")
    private String accessToken;

    private String ACCESS_TOKEN = "token " + accessToken;

    private Logger logger = LoggerFactory.getLogger(GithubService.class);
    private RepositoryInterface service = null;
    

    public static final String API_BASE_URL = "https://api.github.com/";

    public static final String API_VERSION_SPEC = "application/vnd.github.v3+json";

    public static final String JSON_CONTENT_TYPE = "application/json";
    

    public GithubService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RepositoryInterface.class);
    }

    public List<GithubRepository> getRepositories() throws IOException {
        Call<List<GithubRepository>> reposCall = service.listRepos("token " + accessToken, API_VERSION_SPEC);

        Response<List<GithubRepository>> reposResponse = null;
        List<GithubRepository> repos = null;
        reposResponse = reposCall.execute();

        if (reposResponse.isSuccessful()) {
            repos = reposResponse.body();
            if (repos != null) {
                logger.info("Connection to Github was successful");
            } else
                logger.info("Zero repositories found");
        } else {
            ResponseBody errorResponse = reposResponse.errorBody();
            if (errorResponse != null) {
                logger.warn(errorResponse.toString());
                logger.warn("AcessToken from @Value: {}", accessToken);
                logger.warn("ACCESS_TOKEN from @Value: {}", ACCESS_TOKEN);
            }
        }

        return repos;
    }
}


