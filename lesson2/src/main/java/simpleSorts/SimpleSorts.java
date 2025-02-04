package main.java.simpleSorts;

import java.util.Arrays;
import java.util.Scanner;

public class SimpleSorts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();

        int[] arrBubble = Arrays.copyOf(array, array.length);
        int[] arrInsertion = Arrays.copyOf(array, array.length);
        int[] arrSelection = Arrays.copyOf(array, array.length);

        bubbleSort(arrBubble);
        insertionSort(arrInsertion);
        selectionSort(arrSelection);

        System.out.println("Пузырьковая сортировка: " + Arrays.toString(arrBubble));
        System.out.println("Сортировка вставками: " + Arrays.toString(arrInsertion));
        System.out.println("Сортировка выбором: " + Arrays.toString(arrSelection));
    }

    // Сортировка пузырьком
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Сортировка вставками
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

    // Сортировка выбором
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    // Вспомогательный метод для обмена элементов
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
