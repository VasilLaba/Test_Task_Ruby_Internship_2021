package com.mobidev.task3;

public class Goods {
    int id;
    String name;
    int prise;

    public Goods(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.prise = cost;
    }

    public Goods() {
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

    public int getPrise() {
        return prise;
    }

    public void setPrise(int prise) {
        this.prise = prise;
    }
}
