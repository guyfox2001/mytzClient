package com.stupin.tz.InterfaceAPI;

import com.stupin.tz.entities.DOCTOR;
import com.stupin.tz.entities.NDS_TYPE;
import com.stupin.tz.entities.SERVICE;
import com.stupin.tz.entities.SERVICE_GROUP;
import com.stupin.tz.entities.SERVICE_TYPE;
import com.stupin.tz.entities.WORKER;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    @GET("medicinfo/{MEDORG_ID}/{BRA_ID}")
    public Call<ArrayList<WORKER>> getWorkers(@Path("MEDORG_ID") int ID, @Path("BRA_ID") int BRA_ID);
    @GET("allService/{MEDORG_ID}/")
    public Call<ArrayList<SERVICE>> getService(@Path("MEDORG_ID") int ID, @Query("SOURCE") int ID_SOURCE);
    @GET("allServiceGroup/{MEDORG_ID}")
    public Call<ArrayList<SERVICE_GROUP>> getServiceGroup(@Path("MEDORG_ID") int ID);
    @GET("serviceType")
    public Call<ArrayList<SERVICE_TYPE>> getServiceType();
    @GET("allspec/{MEDORG_ID}")
    public Call<ArrayList<DOCTOR>> getDoctor(@Path("MEDORG_ID") int ID);
    @GET("allSpecForBranch/{MEDORG_ID}/{BRA_ID}")
    public Call<ArrayList<DOCTOR>> getAllDoctor (@Path("MEDORG_ID") int ID, @Path("BRA_ID") int BRA_ID);
    @GET("ndsType")
    public Call<ArrayList<NDS_TYPE>> getNDS();
}
