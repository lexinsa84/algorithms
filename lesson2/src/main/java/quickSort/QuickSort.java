package main.java.quickSort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 1, 2, 7, 6, 4};

        System.out.println("Исходный массив: " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
