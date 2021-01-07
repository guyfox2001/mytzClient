package com.stupin.tz.app_service;

import androidx.annotation.NonNull;

import com.stupin.tz.InterfaceAPI.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    public static NetworkService InstanceNetworkService;
    public static String InstanceURL;
    private Retrofit retrofit;

    public NetworkService() {
            InstanceURL = "https://testapi.simplex48.ru/api/Web/";
            retrofit = new Retrofit.Builder()
                    .baseUrl(InstanceURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }
    public static NetworkService getInstanse(){
        if(InstanceNetworkService == null){
            InstanceNetworkService = new NetworkService();
        }
        return InstanceNetworkService;
    }
    public API getAPI(){
        return this.retrofit.create(API.class);
    }
}
