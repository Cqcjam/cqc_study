package com.cqc.learning.algorithm;

import com.alibaba.fastjson.JSON;

/**
 * @author
 */
public class SortedTest {

    public static void main(String[] args) {
        Integer []arr = new Integer[]{1,8,6,4,9,3,2};
        quickSort(arr);
        arr = new Integer[]{1,8,6,4,9,3,2};
        bubbleSort(arr);
        arr = new Integer[]{1,8,6,4,9,3,2};
        directInsert(arr);
        arr = new Integer[]{1,8,6,4,9,3,2};
        selectSort(arr);
        arr = new Integer[]{1,8,6,4,9,3,2};
        binarySort(arr);
    }

    private static void binarySort(Integer[] arr) {
    }

    private static void selectSort(Integer[] arr) {
        System.out.println("选择排序开始。。。。");
        System.out.println("待排序元素" +JSON.toJSONString(arr));
        int min, temp;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        System.out.println("排序后的元素" + JSON.toJSONString(arr));

    }

    private static void directInsert(Integer[] arr) {
        System.out.println("直接插入排序开始。。。。");
        System.out.println("待排序元素" +JSON.toJSONString(arr));
        int currentIndex, temp;
        for (int i = 1; i < arr.length; i++) {
            currentIndex = i - 1;
            temp = arr[i];
            while ( currentIndex >= 0 && arr[currentIndex] > temp) {
                arr[currentIndex + 1] = arr[currentIndex];
                currentIndex--;
            }
            arr[currentIndex + 1] = temp;
        }
        System.out.println("排序后的元素" + JSON.toJSONString(arr));

    }

    private static void bubbleSort(Integer[] arr) {
        System.out.println("冒泡排序开始。。。。");
        System.out.println("待排序元素" +JSON.toJSONString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    arr[j] = arr[j] ^ arr[j+1];
                    arr[j+1] = arr[j] ^ arr[j+1];
                    arr[j] = arr[j] ^ arr[j+1];
                }
            }
        }
        System.out.println("排序后的元素" + JSON.toJSONString(arr));
    }

    private static void quickSort(Integer[] arr) {








    }
}
