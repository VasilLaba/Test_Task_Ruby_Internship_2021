package com.mobidev.task3;

import java.util.ArrayList;

public class Town {
    String townName;
    int townId;
    Goods salt;
    Goods fish;
    Goods cloth;
    Goods copper;
    Goods furs;
    ArrayList<Goods> Cargo = new ArrayList<>();

    public Town(String name, int id, int saltPrise, int fishPrise, int clothPrise, int copperPrise, int fursPrise) {
        this.townName = name;
        this.townId = id;
        this.salt = new Goods(0,"salt", saltPrise);
        Cargo.add(salt);
        this.fish = new Goods(1,"fish", fishPrise);
        Cargo.add(fish);
        this.cloth = new Goods(2,"cloth", clothPrise);
        Cargo.add(cloth);
        this.copper = new Goods(3,"copper", copperPrise);
        Cargo.add(copper);
        this.furs = new Goods(4,"furs", fursPrise);
        Cargo.add(furs);

    }

    public String getProductNameById(int id) throws Exception {
        for (Goods goods : Cargo){
            if (id == goods.getId())
                return goods.getName();
        }
        throw new Exception("Invalid Id");
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public int getTownId() {
        return townId;
    }

    public void setTownId(int townId) {
        this.townId = townId;
    }

    public Goods getSalt() {
        return salt;
    }

    public void setSalt(Goods salt) {
        this.salt = salt;
    }

    public Goods getFish() {
        return fish;
    }

    public void setFish(Goods fish) {
        this.fish = fish;
    }

    public Goods getCloth() {
        return cloth;
    }

    public void setCloth(Goods cloth) {
        this.cloth = cloth;
    }

    public Goods getCopper() {
        return copper;
    }

    public void setCopper(Goods copper) {
        this.copper = copper;
    }

    public Goods getFurs() {
        return furs;
    }

    public void setFurs(Goods furs) {
        this.furs = furs;
    }
}
