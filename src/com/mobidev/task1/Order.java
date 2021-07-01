package com.mobidev.task1;

import java.util.ArrayList;

public class Order implements ISumOfTheOrder{

    ArrayList<Double> orderItemsList = new ArrayList<Double>();
    ArrayList<Double> discountsList = new ArrayList<Double>();

    public Order(ArrayList<Double> orderItems, ArrayList<Double> discounts) {
        this.orderItemsList = orderItems;
        this.discountsList = discounts;
    }

    @Override
    public double getTotalSum() {
        double sum = 0;
        for(double items : orderItemsList){
            sum+=items;
        }
        for(double discounts : discountsList){
            sum-=discounts;
        }
        return sum;
    }
}
