package main.java.tests;

import java.util.Arrays;
import java.util.Random;

public class SortingPerformanceTest {
    public static void main(String[] args) {
        int size = 100_000; // Размер массива
        int[] array1 = generateRandomArray(size);
        int[] array2 = Arrays.copyOf(array1, array1.length);
        int[] array3 = Arrays.copyOf(array1, array1.length);

        System.out.println("Тестируем сортировки на массиве размером " + size + " элементов...");

        // 🔹 Тестируем QuickSort
        long start = System.nanoTime();
        quickSort(array1, 0, array1.length - 1);
        long quickSortTime = System.nanoTime() - start;
        System.out.println("QuickSort: " + (quickSortTime / 1_000_000) + " мс");

        // 🔹 Тестируем BubbleSort (медленный)
        start = System.nanoTime();
        bubbleSort(array2);
        long bubbleSortTime = System.nanoTime() - start;
        System.out.println("BubbleSort: " + (bubbleSortTime / 1_000_000) + " мс");

        // 🔹 Тестируем InsertionSort (медленный)
        start = System.nanoTime();
        insertionSort(array3);
        long insertionSortTime = System.nanoTime() - start;
        System.out.println("InsertionSort: " + (insertionSortTime / 1_000_000) + " мс");
    }

    // 🔹 Генерация случайного массива
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100_000); // Числа от 0 до 99 999
        }
        return arr;
    }

    // 🔹 Быстрая сортировка (QuickSort)
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

    // 🔹 Пузырьковая сортировка (BubbleSort)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 🔹 Сортировка вставками (InsertionSort)
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // 🔹 Метод обмена элементов
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
