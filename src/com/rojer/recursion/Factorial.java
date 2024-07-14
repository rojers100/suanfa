package com.rojer.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 递归方法
 */
public class Factorial {

    /**
     * 使用递归计算阶乘 1*2*3*4*5
     *
     * @param n 进行几位的阶乘
     */
    public static int factorial(int n) {
        if (n == 0) {
            return 1; // 基准条件
        } else {
            return n * factorial(n - 1); // 递归步骤
        }
    }

//    public static void main(String[] args) {
//        int result = factorial(5);
//        System.out.println("5的阶乘 = " + result);
//    }

    /**
     * 递归的二分查找法
     *
     * @param array  遍历的正序数组
     * @param target 目标值
     * @return 对应目标值在数组的下标
     */
    public static int binarySearch(int[] array, int target) {
        return factorial2(array, target, 0, array.length - 1);
    }

    private static int factorial2(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return factorial2(array, target, left, mid - 1);
        } else {
            return factorial2(array, target, mid + 1, right);
        }
    }

    // 测试方法
//    public static void main(String[] args) {
//        int[] array = {1, 3, 5, 7, 9, 11, 13, 15};
//        int target = 11;
//        int index = binarySearch(array, target);
//
//        if (index != -1) {
//            System.out.println("目标值 " + target + " 找到，索引位置为 " + index);
//        } else {
//            System.out.println("目标值 " + target + " 未找到");
//        }
//    }

    /**
     * 递归的冒泡排序法
     *
     * @param array 排序数组
     */
    public static void bubbleSortByFactorial(int[] array) {
        bubbleSort1(array, array.length - 1);
    }

    private static void bubbleSort1(int[] array, int index) {
        if (index == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < index; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                x = i;
            }
        }
        bubbleSort1(array, x);
    }

//    public static void main(String[] args) {
//        int[] array = { 2, 21, 13, 4, 45, 16, 7, 11, 9 };
//        bubbleSortByFactorial(array);
//        System.out.println(Arrays.toString(array));
//    }

    /**
     * 冒泡排序基本写法
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换相邻元素
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // 如果没有发生交换，说明数组已经有序
            if (!swapped) break;
        }
    }

    /**
     * 插入排序之递归写法
     *
     * @param array
     */
    public static void insertionSortByFactorial(int[] array) {
        insertion(array, 1);
    }

    private static void insertion(int[] array, int index) {
        if (index == array.length) {
            return;
        }

        int t = array[index];
        int i = index - 1; // 已排序区域指针
        while (i >= 0 && array[i] > t) {
            array[i + 1] = array[i];
            i--;
        }
        if (i + 1 != index) {
            array[i + 1] = t;
        }
        insertion(array, index + 1);
    }

    public static void main(String[] args) {
        int[] array = {2, 21, 13, 4, 45, 16, 7, 11, 9};
        insertionSortByFactorial(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序基本写法
     */
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            // 将大于key的元素向右移动一个位置
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    /**
     * 斐波那契数列
     */
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // 基准条件
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // 递归步骤
        }
    }

    /**
     * 优化后的斐波那契数列
     */

    //    优化斐波那契数列的计算，可以使用记忆化技术来缓存已经计算过的值，从而避免重复计算。这种方法可以显著提高计算效率，
    //    特别是在计算较大斐波那契数时。以下是使用Java实现记忆化斐波那契数列的代码示例。

    // 使用HashMap来缓存已经计算过的斐波那契数
    private static Map<Integer, Long> memo = new HashMap<>();

    // 记忆化的斐波那契数列计算方法
    public static long fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }

        // 如果缓存中已经存在该值，则直接返回
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // 递归计算斐波那契数，并将结果存入缓存
        long result = fibonacci2(n - 1) + fibonacci(n - 2);
        memo.put(n, result);

        return result;
    }

    // 动态规划的斐波那契数列计算方法
    public static long fibonacci3(int n) {
        if (n <= 1) {
            return n;
        }

        long[] fib = new long[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }

    /**
     * 汉诺塔问题
     *
     * @param n 圆盘个数
     * @param fromRod 源
     * @param toRod 借
     * @param auxRod 目
     */
    public static void solveHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + fromRod + " to " + toRod);
            return;
        }
        solveHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from " + fromRod + " to " + toRod);
        solveHanoi(n - 1, auxRod, toRod, fromRod);
    }


}
