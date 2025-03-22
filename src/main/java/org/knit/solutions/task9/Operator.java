package org.knit.solutions.task9;

import java.util.concurrent.BlockingQueue;

public class Operator implements Runnable {
    private final BlockingQueue<Detail> assemblingQueue;
    private final BlockingQueue<Detail> warehouseQueue;
    private final int warehouseCapacity = 5;

    public Operator(BlockingQueue<Detail> assemblingQueue, BlockingQueue<Detail> warehouseQueue) {
        this.assemblingQueue = assemblingQueue;
        this.warehouseQueue = warehouseQueue;
    }

    @Override
    public void run() {
        try {
            while (warehouseQueue.size() <= warehouseCapacity) {
                Detail detail = assemblingQueue.take();
                Thread.sleep(2000);
                warehouseQueue.put(detail);
                System.out.printf("Оператор контроля: Деталь %d проверена и отправлена на склад%n", detail.getId());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
