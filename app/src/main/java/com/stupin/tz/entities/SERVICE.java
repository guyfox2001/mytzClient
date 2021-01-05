package com.stupin.tz.entities;

public class SERVICE
{
    private int id; //идентификатор услуги
    private int doct_id;//идентификатор специальности
    private int serv_grp_id; //идентификатор группы
    private String name;//наименование
    private String code; //код
    private String description;//описание
    private int duration; //длительность оказания (в минутах)
    private String deadline; //длительность выполнения (для типа услуги "лабораторные исследования (анализы)"
    private double price; //цена
    private int nds; //ставка ндс
    private int serv_type_id; //тип услуги

    public SERVICE(int id,
                   int doct_id,
                   int serv_grp_id,
                   String name,
                   String code,
                   String description,
                   int duration,
                   String deadline,
                   double price,
                   int nds,
                   int serv_type_id) {
        this.id = id;
        this.doct_id = doct_id;
        this.serv_grp_id = serv_grp_id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.duration = duration;
        this.deadline = deadline;
        this.price = price;
        this.nds = nds;
        this.serv_type_id = serv_type_id;
    }
}
