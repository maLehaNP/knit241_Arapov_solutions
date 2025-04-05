package org.knit.solutions.task11;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Stock {
    private String name;
    private float price;
    List<StockObserver> observers = new ArrayList<StockObserver>();

    public Stock(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        notifyObservers(this.price, price);
        this.price = price;
    }

    public void addObservers(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObservers(StockObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(float oldPrice, float newPrice) {
        for (StockObserver observer : observers) {
            observer.notifyUsers(this, oldPrice, newPrice);
        }
    }
}
