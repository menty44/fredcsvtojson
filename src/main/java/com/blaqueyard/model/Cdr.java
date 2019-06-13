package com.blaqueyard.model;

public class Cdr {
    private String name;
    private int Age;
    private int Id_Number;
    private int Phone_Number;
    private String Kra_Pin;

    public Cdr() {
    }

    public Cdr(String name, int age, int id_Number, int phone_Number, String kra_Pin) {
        this.name = name;
        Age = age;
        Id_Number = id_Number;
        Phone_Number = phone_Number;
        Kra_Pin = kra_Pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getId_Number() {
        return Id_Number;
    }

    public void setId_Number(int id_Number) {
        Id_Number = id_Number;
    }

    public int getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(int phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getKra_Pin() {
        return Kra_Pin;
    }

    public void setKra_Pin(String kra_Pin) {
        Kra_Pin = kra_Pin;
    }
}
