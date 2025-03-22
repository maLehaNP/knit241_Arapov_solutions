package org.knit.solutions.task10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable{
    private final int id;
    private final CyclicBarrier barrier;

    public Runner(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("Бегун № " + id + " направляется к линии старта");
            int time = ThreadLocalRandom.current().nextInt(1000, 3000);
            Thread.sleep(time);
            System.out.println("Бегун № " + id + " прибыл за " + time + " мc");
            System.out.println("Бегун № " + id + " ожидает на старте");
            barrier.await(); // Ждет всех остальных
            System.out.println("Бегун № " + id + " побежал");
            time = ThreadLocalRandom.current().nextInt(3000, 5000);
            Thread.sleep(time);
            System.out.println("Бегун № " + id + " пробежал за " + time + " мc");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
