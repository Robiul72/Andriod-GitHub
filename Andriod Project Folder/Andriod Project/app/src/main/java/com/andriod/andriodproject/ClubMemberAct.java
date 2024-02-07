package com.andriod.andriodproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.andriod.andriodproject.adepter.ClubAdepter;
import com.andriod.andriodproject.api.ApiClient;
import com.andriod.andriodproject.api.ClubApi;
import com.andriod.andriodproject.model.ClubModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClubMemberAct extends AppCompatActivity {

    private List<ClubModel> memberList;
    RecyclerView recyclerView;

    ClubAdepter adepter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_member);

        recyclerView = findViewById(R.id.memberListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ClubApi api = ApiClient.getRetrofitInstance().create(ClubApi.class);
        Call<List<ClubModel>> call = api.getClub();




        call.enqueue(new Callback<List<ClubModel>>() {
            @Override
            public void onResponse(Call<List<ClubModel>> call, Response<List<ClubModel>> response) {

                if(response.isSuccessful()){
                    List<ClubModel> memberList = response.body();
                    adepter = new ClubAdepter(memberList, getApplicationContext());
                    recyclerView.setAdapter(adepter);
                }
                else{}
            }



            @Override
            public void onFailure(Call<List<ClubModel>> call, Throwable t) {

            }
        });


    }
}