package org.knit.solutions;

import org.knit.TaskDescription;

/**
 * Условие задачи:
 * Даны два целочисленных массива nums1 и nums2, отсортированных в неубывающем порядке, а также два целых числа m и n, представляющих количество элементов в nums1 и nums2 соответственно.
 * <p>
 * Требуется:
 * Объединить nums1 и nums2 в один массив, отсортированный в неубывающем порядке.
 * <p>
 * Важные условия:
 * 1. Итоговый отсортированный массив должен быть сохранён внутри массива nums1 (функция не должна ничего возвращать).
 * 2. Массив nums1 имеет длину m + n, где:
 * - Первые m элементов — значимые (их нужно объединять с nums2).
 * - Последние n элементов заполнены нулями и должны быть проигнорированы.
 * 3. Длина nums2 равна n.
 */
@TaskDescription(taskNumber = 19, taskDescription = "merge")
public class Task19 implements Solution {
    /**
     * Объединяет nums1 и nums2 в один массив, отсортированный в неубывающем порядке.
     * Первые m элементов — значимые (объединяются с nums2).
     * Последние n элементов заполнены нулями и будут проигнорированы.
     *
     * @param nums1 Первый массив (изменяется на месте)
     * @param m     Количество элементов в nums1
     * @param nums2 Второй массив
     * @param n     Количество элементов в nums2
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int n_ = 0;
        if (m != 0 & n != 0) {
            for (int i = 0; i < nums1.length - 1; i++) {
                if (n_ != n) {
                    if ((nums1[i] <= nums2[n_] & nums1[i + 1] >= nums2[n_]) | nums1[i + 1] == 0) {
                        for (int j = nums1.length - 1; j >= i + 2; j--) {
                            nums1[j] = nums1[j - 1];
                        }
                        nums1[i + 1] = nums2[n_];
                        n_++;
                    }
                }
            }
        }
    }

    public void execute() {
        int[] nums11 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums12 = {2, 5, 6};
        int n1 = 3;
        merge(nums11, m1, nums12, n1);
        for (int x : nums11) {
            System.out.print(x + ", ");
        }

        int[] nums21 = {1};
        int m2 = 1;
        int[] nums22 = {};
        int n2 = 0;
        merge(nums21, m2, nums22, n2);
        for (int x : nums21) {
            System.out.print(x + ", ");
        }

        int[] nums31 = {1, 2, 3, 0, 0, 0};
        int m3 = 3;
        int[] nums32 = {};
        int n3 = 0;
        merge(nums31, m3, nums32, n3);
        for (int x : nums31) {
            System.out.print(x + ", ");
        }
    }
}
