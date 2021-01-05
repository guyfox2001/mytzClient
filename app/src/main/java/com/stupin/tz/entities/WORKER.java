package com.stupin.tz.entities;

import java.util.List;

public class WORKER {
    private int id;
    private String name;
    private String photo;//фото врача в формате BASE64, «-1» - если фото отсутствует
    private String desc;//Описание
    private String specialization; //специализация
    private String qualification; // квалификация
    private String services;  // оказываемые услуги
    private List<Integer> DOCT_IDs;  // список идентификаторов специальностей врача

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
}
