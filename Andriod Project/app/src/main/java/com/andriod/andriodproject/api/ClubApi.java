package com.andriod.andriodproject.api;

import com.andriod.andriodproject.model.ClubModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public abstract class ClubApi {

    @GET("http://localhost:8085/api/owner")
    abstract Call<List<ClubModel>> getClub();


}
