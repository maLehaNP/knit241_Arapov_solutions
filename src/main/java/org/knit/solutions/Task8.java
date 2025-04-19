package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.task8.Car;
import org.knit.solutions.task8.Crossroads;
import org.knit.solutions.task8.TrafficLight;

/**
 * 📌 Описание:
 * На перекрестке светофор управляет движением:
 * - Красный свет – машины стоят (wait()).
 * - Зеленый свет – машины едут (notifyAll()).
 * - Светофор переключается каждые 5 секунд.
 *
 * 🔹 Что нужно реализовать?
 * ✔ Поток "Светофор" изменяет цвет и отправляет notifyAll().
 * ✔ Потоки "Машина" ждут wait(), если красный свет.
 */
@TaskDescription(taskNumber = 8, taskDescription = "Перекресток: светофор и машины")
public class Task8 implements Solution {
    public void execute() {
        Crossroads crossroads = new Crossroads();

        Thread threadTrafficLight = new Thread(new TrafficLight(crossroads, 5));
        Thread threadCars = new Thread(new Car(crossroads, 30));

        threadTrafficLight.start();
        threadCars.start();
    }
}
