package org.knit.solutions;

import org.junit.*;

import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.knit.solutions.Task19.merge;

public class MergeTest {
    @Test
    public void testNormalCases() {
        int[] nums11 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums12 = {2, 5, 6};
        int n1 = 3;

        int[] nums21 = {1};
        int m2 = 1;
        int[] nums22 = {};
        int n2 = 0;

        merge(nums11, m1, nums12, n1);
        merge(nums21, m2, nums22, n2);

        assertArrayEquals(nums11, new int[]{1, 2, 2, 3, 5, 6});
        assertArrayEquals(nums21, new int[]{1});
    }

    @Test
    public void testEdgeCases() {
        int[] nums11 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums12 = {};
        int n1 = 0;

        int[] nums21 = {};
        int m2 = 0;
        int[] nums22 = {2, 5, 6};
        int n2 = 3;

        int[] nums31 = {};
        int m3 = 0;
        int[] nums32 = {};
        int n3 = 0;

        merge(nums11, m1, nums12, n1);
        merge(nums21, m2, nums22, n2);
        merge(nums31, m3, nums32, n3);

        assertArrayEquals(nums11, new int[]{1, 2, 3, 0, 0, 0});
        assertArrayEquals(nums21, new int[]{});
        assertArrayEquals(nums31, new int[]{});
    }

    @Test
    public void testNegative() {
        int[] nums11 = {-1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums12 = {1, 5, 6};
        int n1 = 3;

        int[] nums21 = {1, 2, 2, 0, 0, 0};
        int m2 = 3;
        int[] nums22 = {2, 5, 6};
        int n2 = 3;

        merge(nums11, m1, nums12, n1);
        merge(nums21, m2, nums22, n2);

        assertArrayEquals(nums11, new int[]{-1, 1, 2, 3, 5, 6});
        assertArrayEquals(nums21, new int[]{1, 2, 2, 2, 5, 6});
    }

    @Test
    public void testPerformance() {
        Random rnd = new Random();
        int m = rnd.nextInt(201);
        int n = rnd.nextInt(201 - m);
        System.out.println(m + " " + n);
        int[] nums1 = new int[200];
        int[] nums2 = new int[n];

        for (int i = 0; i < m; i++) {
            nums1[i] = rnd.nextInt(1000000001);
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = rnd.nextInt(1000000001);
        }

        long startTime = System.nanoTime();
        merge(nums1, m, nums2, n);
        long stopTime = System.nanoTime();
        long time = stopTime - startTime;

        System.out.println("Nanoseconds: " + time);
        System.out.println("Microseconds: " + time / 1000.);
        System.out.println("Milliseconds: " + time / 1000000.);
        System.out.println("Seconds: " + time / 1000000000.);

        assertTrue(time < 1500000.);
    }
}
