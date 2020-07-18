package com.zyonel.fixtures.network;

import com.zyonel.fixtures.models.MatchResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FixtureService {

    @GET("matches?status=SCHEDULED")
    Call<MatchResponse> getMatches();
}
