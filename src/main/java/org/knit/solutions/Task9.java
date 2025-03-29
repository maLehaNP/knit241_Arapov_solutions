package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.task9.Assembler;
import org.knit.solutions.task9.Detail;
import org.knit.solutions.task9.Operator;
import org.knit.solutions.task9.Stamper;

import java.util.concurrent.*;

/**
 * Описание задачи:
 * На заводе работают три типа рабочих, каждый из которых выполняет свою часть работы в конвейерном режиме:
 * 1. Штамповщик – вырезает заготовку (создает объект детали).
 * 2. Сборщик – собирает из заготовки готовую деталь.
 * 3. Оператор контроля качества – проверяет деталь и отправляет на склад.
 * Каждый рабочий – отдельный поток, и они должны работать последовательно, используя общую очередь для передачи деталей.
 *
 * Требования к решению:
 * - Использовать потоки (Thread или ExecutorService).
 * - Использовать синхронизацию (wait(), notify(), BlockingQueue).
 * - Реализовать конвейерную передачу данных между потоками.
 */
@TaskDescription(taskNumber = 9, taskDescription = "Конвейер сборки деталей")
public class Task9 implements Solution {
    public void execute() {
        BlockingQueue<Detail> assemblingQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Detail> stampingQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Detail> warehouseQueue = new LinkedBlockingQueue<>();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Stamper(stampingQueue, 5));
        executorService.submit(new Assembler(stampingQueue, assemblingQueue, 5));
        executorService.submit(new Operator(assemblingQueue, warehouseQueue));
    }
}
