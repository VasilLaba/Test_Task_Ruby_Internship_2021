package com.mobidev;

import com.mobidev.task1.Order;
import com.mobidev.task2.XOGame;
import com.mobidev.task3.Town;
import com.mobidev.task3.Trader;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// Task 1
        //Develop a program to calculate the sum of the Order in Online Shop
        //The Order consists of: the list of Order Items and the list of Discounts.
        //Order Items is an array of items prices. Discounts is an array of discounts for each Order Item in percent.
        System.out.println("Task 1:");
        ArrayList<Double> orderItems = new ArrayList<Double>();
        orderItems.add(100.0);
        orderItems.add(112.2);
        orderItems.add(301.1);

        ArrayList<Double> discounts = new ArrayList<Double>();
        discounts.add(10.0);
        discounts.add(0.0);
        discounts.add(0.0);

        Order smOrder = new Order(orderItems,discounts);
        smOrder.getTotalSum();
        System.out.println(smOrder.getTotalSum());

    //Task 2
        //Create a program, which determines the winner in the XO (Tic Tac Toe) game
        //As an input this function should receive the game board (two dimensional array aka matrix).
        //As an output it should return the winner ‘X’ or ‘‘O’ (return ‘’ if no winner).
        System.out.println("Task 2:");
        char[][] tab1 = new char[][]
                {
                        {'X', ' ', ' '},
                        {' ', 'X', ' '},
                        {'O', ' ', 'O'}
                };
        char[][] tab2 = new char[][]
                {
                        {' ', 'X', ' '},
                        {'X', 'X', ' '},
                        {'O', 'O', 'O'}
                };
        XOGame newGame = new XOGame(tab1);
        newGame.startTheGame();
        newGame = new XOGame(tab2);
        newGame.startTheGame();


    //Task 3
        //There are 3 towns. Each town provides goods for certain prices. Town/price reference:
        /*
        TOWN 1 - Lubeck
        Good prices:
        salt- 20 coins
        fish- 50 coins
        cloth- 60 coins
        copper- 36 coins
        furs- 96 coins

        TOWN 2 - Reval
        Good prices:
        salt- 35 coins
        fish- 50 coins
        cloth- 40 coins
        copper- 60 coins
        furs- 45 coins

        TOWN 3 - Bergen
        Good prices:
        salt- 62 coins
        fish- 15 coins
        cloth- 18 coins
        copper- 82 coins
        furs- 54 coins
        */
        //Trader starts outside of any town with 50 coins.
        //He can visit each town only once.
        //When in town he can buy/sell goods for a given price, carrying no more than one good while traveling
        //between towns.
        //He should get maximum possible profit in the process.
        //Write a program that’ll execute merchants traveling and trading, printing final and intermediate merchants
        //coins after visiting all 3 cities.

        System.out.println("Task 3:");

        Town Lubeck = new Town("Lubeck",0, 20, 50, 60, 36, 96);
        Town Reval = new Town("Reval", 1, 35, 50,40,60,45);
        Town Bergen = new Town("Bergen", 2, 62, 15,18,82,54);

        Trader trader1 = new Trader();
        try {
            trader1.getPaths(Lubeck,Reval, Bergen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
