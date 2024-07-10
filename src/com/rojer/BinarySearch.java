package com.rojer;

public class BinarySearch {

    // 二分查找方法
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // 找到目标值，返回索引
            } else if (array[mid] < target) {
                left = mid + 1; // 目标值在右半部分
            } else {
                right = mid - 1; // 目标值在左半部分
            }
        }

        return -1; // 没有找到目标值
    }

    // 测试方法
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 11;
        int index = binarySearch(array, target);

        if (index != -1) {
            System.out.println("目标值 " + target + " 找到，索引位置为 " + index);
        } else {
            System.out.println("目标值 " + target + " 未找到");
        }
    }
}
