package com.mobidev.task3;

import java.util.ArrayList;

public class Trader {
    String name;
    ArrayList<Town> towns = new ArrayList<>();
    ArrayList<Path> paths = new ArrayList<>();


    public void getPaths(Town ... towns) throws Exception {
        for(Town town : towns){
            this.towns.add(town);
        }
        for (int i = 0; i < towns.length; i++){
            inFirstTown(i);
        }
        print(getPathByMaxFinalCoins());

        }


    private void print(Path path) throws Exception {
        System.out.println("Run 1 \n" +
                "Initial coins: 50\n" +
                "Buy " + getGoodsById(path.firstGoodsId, getTownById(path.firstTownId)).getName() + " for " +
                        getTownById(path.firstTownId).Cargo.get(path.firstGoodsId).getPrise() + " coins in " +
                        getTownById(path.firstTownId).getTownName()+". " + (50 - getTownById(path.firstTownId).Cargo.get(path.firstGoodsId).getPrise()) +
                        "coins left.\n" +
                "Sell " + getGoodsById(path.firstGoodsId, getTownById(path.firstTownId)).getName() + " for " +
                getTownById(path.secondTownId).Cargo.get(path.firstGoodsId).getPrise() + " coins in " +
                getTownById(path.secondTownId).getTownName()+". " + (50 - getTownById(path.firstTownId).Cargo.get(path.firstGoodsId).getPrise() + getTownById(path.secondTownId).Cargo.get(path.firstGoodsId).getPrise() ) +
                "coins left.\n" +
                "Buy " + getGoodsById(path.secondGoodsId, getTownById(path.secondTownId)).getName() + " for " +
                getTownById(path.secondTownId).Cargo.get(path.secondGoodsId).getPrise() + " coins in " +
                getTownById(path.secondTownId).getTownName()+". " + (50 - getTownById(path.firstTownId).Cargo.get(path.firstGoodsId).getPrise() + getTownById(path.secondTownId).Cargo.get(path.firstGoodsId).getPrise() - getTownById(path.secondTownId).Cargo.get(path.secondGoodsId).getPrise() ) +
                "coins left.\n" +
                "Sell " + getGoodsById(path.secondGoodsId, getTownById(path.finalTownId)).getName() + " for " +
                getTownById(path.finalTownId).Cargo.get(path.secondGoodsId).getPrise() + " coins in " +
                getTownById(path.finalTownId).getTownName()+". \n" +
                "Final coins: " + path.finalCoins);
    }

    private void inFirstTown(int firstTownId){
        try {
            Town town = getTownById(firstTownId);
            int coins = 50;
            for(Goods goods : town.Cargo){
                if (goods.getPrise()>coins)
                    continue;
                coins-= goods.getPrise();
                for (int i = 0; i < towns.size(); i++){
                    if (i == firstTownId)
                        continue;
                    inMidleTown(i, goods.getId(), firstTownId, coins);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void inMidleTown(int middelTownId, int firstGoodsId, int firstTownId, int coins) throws Exception {
        Town town = getTownById(middelTownId);
        coins+= getGoodsById(firstGoodsId, town).getPrise();
        for (Goods goods : town.Cargo){
            if (goods.getId() == firstGoodsId)
                continue;
            if (goods.getPrise()>coins)
                continue;
            for (int i = 0; i < towns.size(); i++){
                if (i == firstTownId)
                    continue;
                if (i == middelTownId)
                    continue;
                coins -= goods.getPrise();
                inFinalTown(firstTownId, firstGoodsId, middelTownId, goods.getId(), i, coins);
            }
        }
    }

    private void inFinalTown(int firstTownId, int firstGoodsId, int middleTownId, int secondGoodsId, int finalTownId, int coins) throws Exception {
        Town town = getTownById(finalTownId);
        coins+=getGoodsById(secondGoodsId, town).getPrise();
        Path path = new Path(firstTownId,firstGoodsId, middleTownId, secondGoodsId, finalTownId, coins);
        paths.add(path);
    }


    private Town getTownById(int townId) throws Exception {
        for (Town town : towns){
            if (town.getTownId() == townId){
                return town;
            }
        }
        throw new Exception("Invalid townId");
    }
    private Goods getGoodsById(int goodsId, Town town) throws Exception {
        for(Goods goods : town.Cargo){
            if (goods.getId() == goodsId)
                return goods;
        }
        throw new Exception("Invalid goodsId");
    }
    private Path getPathByMaxFinalCoins() {
        Path rez = paths.get(0);
        for(Path p : paths){
            if (rez.finalCoins < p.finalCoins)
                rez = p;
        }
        return rez;
    }

}
