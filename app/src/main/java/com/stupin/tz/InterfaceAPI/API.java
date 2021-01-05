package com.stupin.tz.InterfaceAPI;

import com.stupin.tz.entities.DOCTOR;
import com.stupin.tz.entities.NDS_TYPE;
import com.stupin.tz.entities.SERVICE;
import com.stupin.tz.entities.SERVICE_GROUP;
import com.stupin.tz.entities.SERVICE_TYPE;
import com.stupin.tz.entities.WORKER;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    @GET("medicinfo/{MEDORG_ID}/{BRA_ID}")
    public Call<List<WORKER>> getWorkers(@Path("MEDORG_ID") int ID, @Path("BRA_ID") int BRA_ID);
    @GET("allService/{MEDORG_ID}/")
    public Call<List<SERVICE>> getService(@Path("MEDORG_ID") int ID, @Query("SOURCE") int ID_SOURCE);
    @GET("allServiceGroup/{MEDORG_ID}")
    public Call<List<SERVICE_GROUP>> getServiceGroup(@Path("MEDORG_ID") int ID);
    @GET("serviceType")
    public Call<List<SERVICE_TYPE>> getServiceType();
    @GET("allspec/{MEDORG_ID}")
    public Call<List<DOCTOR>> getDoctor(@Path("MEDORG_ID") int ID);
    @GET("allSpecForBranch/{MEDORG_ID}/{BRA_ID}")
    public Call<List<DOCTOR>> getAllDoctor (@Path("MEDORG_ID") int ID, @Path("BRA_ID") int BRA_ID);
    @GET("ndsType")
    public Call<List<NDS_TYPE>> getNDS();
}
