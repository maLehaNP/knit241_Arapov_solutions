package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.task4.GasStation;

/**
 * Полное описание задачи
 */
@TaskDescription(taskNumber = 4, taskDescription = "Автозаправочная станция")
public class Task4 implements Solution {
    public void execute() {
        GasStation gasStation = new GasStation(2);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                gasStation.Refuel(String.valueOf(finalI) + " машина");
            }).start();
        }
    }
}
