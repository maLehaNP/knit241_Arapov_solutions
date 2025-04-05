package org.knit.solutions.task11;

public class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(StockObserver observer, String message) {
        System.out.println("%s получил уведомление от %s: \"%s\".%n");
    }
}
