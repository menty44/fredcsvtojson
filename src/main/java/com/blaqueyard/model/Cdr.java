package com.blaqueyard.model;

public class Cdr {
    private String name;
    private String Age;
    private String Id_Number;
    private String Phone_Number;
    private String Kra_Pin;

    public Cdr() {
    }

    public Cdr(String name, String age, String id_Number, String phone_Number, String kra_Pin) {
        this.name = name;
        Age = age;
        Id_Number = id_Number;
        Phone_Number = phone_Number;
        Kra_Pin = kra_Pin;
    }

    public String getName() {
        return "\""+name+"\"";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return "\""+Age+"\"";
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getId_Number() {
        return "\""+Id_Number+"\"";
    }

    public void setId_Number(String id_Number) {
        Id_Number = id_Number;
    }

    public String getPhone_Number() {
        return "\""+Phone_Number+"\"";

    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getKra_Pin() {
        return "\""+Kra_Pin+"\"";
    }

    public void setKra_Pin(String kra_Pin) {
        Kra_Pin = kra_Pin;
    }
}
