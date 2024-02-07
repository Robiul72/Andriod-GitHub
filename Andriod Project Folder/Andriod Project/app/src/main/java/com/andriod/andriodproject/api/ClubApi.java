package com.andriod.andriodproject.api;



import com.andriod.andriodproject.model.ClubModel;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClubApi {


    @GET("purbachal.php?action=read")
    Call<List<ClubModel>> getClub();
}
