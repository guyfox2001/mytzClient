package com.stupin.tz.app_service;

import androidx.annotation.NonNull;

import com.stupin.tz.MainActivity;
import com.stupin.tz.R;
import com.stupin.tz.entities.SERVICE;
import com.stupin.tz.entities.SERVICE_GROUP;
import com.stupin.tz.entities.SERVICE_TYPE;
import com.stupin.tz.entities.WORKER;

import java.security.Provider;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainService {
    private List<WORKER> workerList;
    private List<SERVICE> serviceList;
    private List<SERVICE_GROUP> serviceGroups;
    private List<SERVICE_TYPE> serviceTypes;
    private MainActivity activity;

    public MainService(MainActivity activity) {
        this.activity = activity;
        this.workerList = null;
        this.serviceList = null;
        this.serviceGroups = null;
        this.serviceTypes = null;
    }

    public void updWorkersList(){
        NetworkService.getInstanse().getAPI().getWorkers(1, 1).enqueue(
        new Callback<List<WORKER>>() {
            @Override
            public void onResponse(Call<List<WORKER>> call, Response<List<WORKER>> response) {
                if (response.isSuccessful()){
                    try {
                        response.body().isEmpty();
                        workerList = response.body();
                    }
                    catch (NullPointerException e){
                        activity.showMessage(activity.getString(R.string.BadResponseAnswer));
                    }
                }
                else{
                    activity.showMessage(activity.getString(R.string.BadResponseAnswer));
                    onFailure(call, new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<List<WORKER>> call, Throwable t) {
                activity.showMessage(activity.getString(R.string.BadResponseAnswer));
            }
        });
    }
    public void updServiceList(){
        NetworkService.getInstanse().getAPI().getService(1, 2).enqueue(
                new Callback<List<SERVICE>>() {
                    @Override
                    public void onResponse(Call<List<SERVICE>> call, Response<List<SERVICE>> response) {
                        if (response.isSuccessful()){
                            try {
                                response.body().isEmpty();
                                serviceList = response.body();
                            }
                            catch (NullPointerException e){
                                activity.showMessage(activity.getString(R.string.BadResponseAnswer));
                            }
                        }
                        else{
                            activity.showMessage(activity.getString(R.string.BadResponseAnswer));
                            onFailure(call, new Throwable(response.message()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<SERVICE>> call, Throwable t) {
                        activity.showMessage(activity.getString(R.string.BadResponseAnswer));
                    }
                });
    }
    public void updServiceGroupsList(){
        NetworkService.getInstanse().getAPI().getServiceGroup(1).enqueue(new Callback<List<SERVICE_GROUP>>() {
            @Override
            public void onResponse(Call<List<SERVICE_GROUP>> call, Response<List<SERVICE_GROUP>> response) {
                if (response.isSuccessful()){
                    try {
                        response.body().isEmpty();
                        serviceGroups = response.body();
                    }
                    catch (NullPointerException e){
                        activity.showMessage(activity.getString(R.string.BadResponseAnswer));
                    }
                }
                else{
                    activity.showMessage(activity.getString(R.string.BadResponseAnswer));
                    onFailure(call, new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<List<SERVICE_GROUP>> call, Throwable t) {
                activity.showMessage(activity.getString(R.string.BadResponseAnswer));
            }
        });
    }
    public void updServiceTypesList(){
        NetworkService.getInstanse().getAPI().getServiceType().enqueue(new Callback<List<SERVICE_TYPE>>() {
            @Override
            public void onResponse(Call<List<SERVICE_TYPE>> call, Response<List<SERVICE_TYPE>> response) {
                if (response.isSuccessful()){
                    try {
                        response.body().isEmpty();
                        serviceTypes = response.body();
                    }
                    catch (NullPointerException e){
                        activity.showMessage(activity.getString(R.string.BadResponseAnswer));
                    }
                }
                else{
                    activity.showMessage(activity.getString(R.string.BadResponseAnswer));
                    onFailure(call, new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<List<SERVICE_TYPE>> call, Throwable t) {
                activity.showMessage(activity.getString(R.string.BadResponseAnswer));
            }
        });
    }
}
