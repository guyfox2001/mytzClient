package com.stupin.tz.entities;

import android.os.Parcel;
import android.os.Parcelable;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class WORKER implements Parcelable {
    private int id;
    private String name;
    private String photo;//фото врача в формате BASE64, «-1» - если фото отсутствует
    private String desc;//Описание
    private String specialization; //специализация
    private String qualification; // квалификация
    private String services;  // оказываемые услуги
    private List<Integer> DOCT_IDs;  // список идентификаторов специальностей врача
    private static WORKER mInstance;

    public static WORKER getmInstance() {
        return mInstance;
    }

    public static void setmInstance(WORKER mInstance) {
        WORKER.mInstance = mInstance;
    }

    public WORKER(int id,
                  String name,
                  String photo,
                  String desc,
                  String specialization,
                  String qualification,
                  String services,
                  List<Integer> DOCT_IDs) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.desc = desc;
        this.specialization = specialization;
        this.qualification = qualification;
        this.services = services;
        this.DOCT_IDs = DOCT_IDs;
    }

    protected WORKER(Parcel in) {
        id = in.readInt();
        desc = in.readString();
        name = in.readString();
        photo = in.readString();
        specialization = in.readString();
        qualification = in.readString();
        services = in.readString();
        Integer size = in.readInt();
        DOCT_IDs = new ArrayList<>();
        for (int i =0 ; i<size; i++){
            DOCT_IDs.add(in.readInt());
        }
    }

    public static final Creator<WORKER> CREATOR = new Creator<WORKER>() {
        @Override
        public WORKER createFromParcel(Parcel in) {
            return new WORKER(in);
        }

        @Override
        public WORKER[] newArray(int size) {
            return new WORKER[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public List<Integer> getDOCT_IDs() {
        return DOCT_IDs;
    }

    public void setDOCT_IDs(List<Integer> DOCT_IDs) {
        this.DOCT_IDs = DOCT_IDs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeCharArray(this.desc.toCharArray());
        dest.writeCharArray(this.name.toCharArray());
        dest.writeCharArray(this.photo.toCharArray());
        dest.writeCharArray(this.specialization.toCharArray());
        dest.writeCharArray(this.qualification.toCharArray());
        dest.writeCharArray(this.services.toCharArray());
        dest.writeInt(this.DOCT_IDs.size());
        for (Integer iter : this.DOCT_IDs) {
            dest.writeInt(iter);
        }
    }
}
