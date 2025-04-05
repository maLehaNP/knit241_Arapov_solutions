package org.knit.solutions.task11;

import java.util.ArrayList;
import java.util.List;

public interface StockObserver {
    List<User> users = new ArrayList<User>();

    default void Subscribe(Stock stock) {
        stock.addObservers(this);
    }

    default void Unsubscribe(Stock stock) {
        stock.removeObservers(this);
    }

    void notifyUsers(Stock stock, float oldPrice, float newPrice);
}
