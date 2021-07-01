package com.mobidev.task3;

public class Path {
    int firstTownId;
    int firstGoodsId;
    int secondTownId;
    int secondGoodsId;
    int finalTownId;
    int finalCoins;

    public Path(int firstTownId, int firstGoodsId, int middleTownId, int secondGoodsId, int finalTownId, int finalCoins) {
        this.firstTownId = firstTownId;
        this.firstGoodsId = firstGoodsId;
        secondTownId = middleTownId;
        this.secondGoodsId = secondGoodsId;
        this.finalTownId = finalTownId;
        this.finalCoins = finalCoins;
    }

    public Path() {
    }

    @Override
    public String toString() {
        return "Path{" +
                "firstTownId=" + firstTownId +
                ", firstGoodsId=" + firstGoodsId +
                ", SecondTownId=" + secondTownId +
                ", SecondGoodsId=" + secondGoodsId +
                ", finalTownId=" + finalTownId +
                ", finalCoins=" + finalCoins +
                '}';
    }
}
