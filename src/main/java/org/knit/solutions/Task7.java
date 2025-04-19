package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.task7.Shop;

/**
 * 📌 Описание:
 * - Производитель создает товары (максимум 5).
 * - Потребитель забирает товары.
 * - Если товаров нет, потребитель ждет (wait()).
 * - Если товаров максимум, производитель ждет (wait()).
 *
 * 🔹 Что нужно реализовать?
 * ✔ wait() – если товаров нет или склад заполнен.
 * ✔ notify() – пробуждение потока, когда изменяется состояние склада.
 */
@TaskDescription(taskNumber = 7, taskDescription = "Производитель-Потребитель с ограничением")
public class Task7 implements Solution {
    @Override
    public void execute() {
        Shop shop = new Shop();
        int prodCount = 10;

        Thread threadProducer = new Thread(() -> {
            try {
                for (int i = 0; i < prodCount; i++) {
                    Thread.sleep(400);
                    shop.produce(i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadConsumer = new Thread(() -> {
            try {
                for (int i = 0; i < prodCount; i++) {
                    shop.consume();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadProducer.start();
        threadConsumer.start();
    }
}
