package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.task10.Runner;

import java.util.concurrent.*;

/**
 * Полное описание задачи
 */
@TaskDescription(taskNumber = 10, taskDescription = "Гонка бегунов с использованием CyclicBarrier")
public class Task10 implements Solution {
    public void execute() {
        int runnerCount = 5;
        CyclicBarrier bar = new CyclicBarrier(runnerCount);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executor.submit(() -> new Runner(finalI, bar).run());
        }
        executor.shutdown();
        while (!executor.isTerminated());
        System.out.println("Гонка завершена");
    }
}
