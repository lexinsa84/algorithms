package main.java.binarySearch;

import java.util.Random;

public class BinarySearchExample {
    public static void main(String[] args) {
        int size = 100_000;
        int[] array = generateSortedArray(size);

        int target = array[new Random().nextInt(size)];
        System.out.println("Ищем число: " + target);

        long start = System.nanoTime();
        int resultIndex = binarySearch(array, 0, array.length - 1, target);
        long searchTime = System.nanoTime() - start;

        if (resultIndex != -1) {
            System.out.println("Число найдено на позиции: " + resultIndex);
        } else {
            System.out.println("Число не найдено.");
        }

        System.out.println("Время поиска: " + (searchTime / 1_000) + " мкс");
    }

    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // Найден элемент
        } else if (arr[mid] > target) {
            return binarySearch(arr, left, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, right, target);
        }
    }
}
