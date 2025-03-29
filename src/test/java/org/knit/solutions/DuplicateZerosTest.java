package org.knit.solutions;

import org.junit.*;

import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.knit.solutions.Task18.duplicateZeros;

public class DuplicateZerosTest {
    @Test
    public void testNormalCases() {
        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 0, 2, 3, 0, 4, 5, 0, 6, 7, 0, 0, 2, 5, 0, 2, 0, 4, 5, 1, 1};
        duplicateZeros(arr1);
        duplicateZeros(arr2);
        duplicateZeros(arr3);
        assertArrayEquals(arr1, new int[]{1, 0, 0, 2, 3, 0, 0, 4});  // Проверка корректного результата
        assertArrayEquals(arr2, new int[]{1, 2, 3});
        assertArrayEquals(arr3, new int[]{1, 0, 0, 2, 3, 0, 0, 4, 5, 0, 0, 6, 7, 0, 0, 0, 0, 2, 5, 0, 0});
    }

    @Test
    public void testEdgeCases() {
        int[] arr1 = {};
        int[] arr2 = {0, 0, 0};
        int[] arr3 = {0, 1, 2, 3, 3, 4, 5, 0};
        int[] arr4 = {0, 0, 2, 3, 3, 4, 0, 0};
        duplicateZeros(arr1);
        duplicateZeros(arr2);
        duplicateZeros(arr3);
        duplicateZeros(arr4);
        assertArrayEquals(arr1, new int[]{});
        assertArrayEquals(arr2, new int[]{0, 0, 0});
        assertArrayEquals(arr3, new int[]{0, 0, 1, 2, 3, 3, 4, 5});
        assertArrayEquals(arr4, new int[]{0, 0, 0, 0, 2, 3, 3, 4});
    }

    @Test
    public void testPerformance() {
        Random rnd = new Random();
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = rnd.nextInt(10);
        }

        long startTime = System.nanoTime();
        duplicateZeros(arr);
        long stopTime = System.nanoTime();
        long time = stopTime - startTime;

        System.out.println("Nanoseconds: " + time);
        System.out.println("Microseconds: " + time / 1000.);
        System.out.println("Milliseconds: " + time / 1000000.);
        System.out.println("Seconds: " + time / 1000000000.);

        assertTrue(time < 10000000.);
    }
}
