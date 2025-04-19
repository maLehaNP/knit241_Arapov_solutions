package org.knit.solutions.task11;

import java.util.List;

public class EmailNotifier implements StockObserver {
    @Override
    public void notifyUsers(Stock stock, float oldPrice, float newPrice) {
        for (User user : users) {
            String message = String.format("s", stock.getName(), oldPrice, newPrice);
            user.sendMessage(this, "");
        }
    }
}
