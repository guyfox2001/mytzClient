package com.stupin.tz.app_service;

import com.stupin.tz.MainActivity;
import com.stupin.tz.R;
import com.stupin.tz.entities.DOCTOR;
import com.stupin.tz.entities.SERVICE;
import com.stupin.tz.entities.SERVICE_GROUP;
import com.stupin.tz.entities.SERVICE_TYPE;
import com.stupin.tz.entities.WORKER;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainService {
    private ArrayList<DOCTOR> doctorArrayList;
    private ArrayList<WORKER> workerArrayList;
    private ArrayList<SERVICE> serviceArrayList;
    private ArrayList<SERVICE_GROUP> serviceGroups;
    private ArrayList<SERVICE_TYPE> serviceTypes;
    private MainActivity activity;

    public MainService(MainActivity activity) {
        this.activity = activity;
        this.workerArrayList  = new ArrayList<>();
        this.serviceArrayList = new ArrayList<>();
        this.serviceGroups    = new ArrayList<>();
        this.serviceTypes     = new ArrayList<>();
        this.doctorArrayList  = new ArrayList<>();
    }

    public ArrayList<DOCTOR> getDoctorArrayList() {
        return doctorArrayList;
    }

    public ArrayList<WORKER> getWorkerArrayList() { return workerArrayList; }

    public ArrayList<SERVICE> getServiceArrayList() {
        return serviceArrayList;
    }

    public ArrayList<SERVICE_GROUP> getServiceGroups() {
        return serviceGroups;
    }

    public ArrayList<SERVICE_TYPE> getServiceTypes() {
        return serviceTypes;
    }

    public void updAllDoctorArrayList(){
        NetworkService.getInstanse().getAPI().getAllDoctor(1,1).enqueue(new Callback<ArrayList<DOCTOR>>() {
            @Override
            public void onResponse(Call<ArrayList<DOCTOR>> call, Response<ArrayList<DOCTOR>> response) {
                if (response.isSuccessful()){
                    try {
                        response.body().isEmpty();
                        doctorArrayList.addAll(response.body());
                        activity.initSpinner();
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
            public void onFailure(Call<ArrayList<DOCTOR>> call, Throwable t) {
                activity.showMessage(activity.getString(R.string.BadResponseAnswer));
            }
        });
    }
    public void updWorkersArrayList(){
        NetworkService.getInstanse().getAPI().getWorkers(1, 1).enqueue(
        new Callback<ArrayList<WORKER>>() {
            @Override
            public void onResponse(Call<ArrayList<WORKER>> call, Response<ArrayList<WORKER>> response) {
                if (response.isSuccessful()){
                    try {
                        response.body().isEmpty();
                        workerArrayList.addAll(response.body());
                        //activity.initRecyclerView();
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
            public void onFailure(Call<ArrayList<WORKER>> call, Throwable t) {
                activity.showMessage(activity.getString(R.string.BadResponseAnswer));
            }
        });
    }
    public void updServiceArrayList(){
        NetworkService.getInstanse().getAPI().getService(1, 2).enqueue(
                new Callback<ArrayList<SERVICE>>() {
                    @Override
                    public void onResponse(Call<ArrayList<SERVICE>> call, Response<ArrayList<SERVICE>> response) {
                        if (response.isSuccessful()){
                            try {
                                response.body().isEmpty();
                                serviceArrayList.addAll(response.body());
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
                    public void onFailure(Call<ArrayList<SERVICE>> call, Throwable t) {
                        activity.showMessage(activity.getString(R.string.BadResponseAnswer));
                    }
                });
    }
    public void updServiceGroupsArrayList(){
        NetworkService.getInstanse().getAPI().getServiceGroup(1).enqueue(new Callback<ArrayList<SERVICE_GROUP>>() {
            @Override
            public void onResponse(Call<ArrayList<SERVICE_GROUP>> call, Response<ArrayList<SERVICE_GROUP>> response) {
                if (response.isSuccessful()){
                    try {
                        response.body().isEmpty();
                        serviceGroups.addAll(response.body());
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
            public void onFailure(Call<ArrayList<SERVICE_GROUP>> call, Throwable t) {
                activity.showMessage(activity.getString(R.string.BadResponseAnswer));
            }
        });
    }
    public void updServiceTypesArrayList(){
        NetworkService.getInstanse().getAPI().getServiceType().enqueue(new Callback<ArrayList<SERVICE_TYPE>>() {
            @Override
            public void onResponse(Call<ArrayList<SERVICE_TYPE>> call, Response<ArrayList<SERVICE_TYPE>> response) {
                if (response.isSuccessful()){
                    try {
                        response.body().isEmpty();
                        serviceTypes.addAll(response.body());
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
            public void onFailure(Call<ArrayList<SERVICE_TYPE>> call, Throwable t) {
                activity.showMessage(activity.getString(R.string.BadResponseAnswer));
            }
        });
    }
    public ArrayList<WORKER> onFilterWorkers (int idChoiced){
        ArrayList<WORKER> item = new ArrayList<>();
        for (WORKER iter:
            this.workerArrayList) {
            if(iter.getId() == idChoiced){
                item.add(iter);
            }
        }
        return item;
    }
}
