package org.knit.solutions.task9;

import java.util.concurrent.BlockingQueue;

public class Assembler implements Runnable {
    private final BlockingQueue<Detail> stampingQueue;
    private final BlockingQueue<Detail> assemblingQueue;
    private int lastDetailId = 1;
    private final int maxDetails;

    public Assembler(BlockingQueue<Detail> stampingQueue, BlockingQueue<Detail> assemblingQueue, int maxDetails) {
        this.stampingQueue = stampingQueue;
        this.assemblingQueue = assemblingQueue;
        this.maxDetails = maxDetails;
    }

    @Override
    public void run() {
        try {
            while (lastDetailId <= maxDetails) {
                Detail detail = null;
                detail = stampingQueue.take();
                Thread.sleep(1500);
                assemblingQueue.put(detail);
                System.out.printf("Сборщик: Заготовка %d обработана%n", detail.getId());
                lastDetailId++;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
