import java.util.Arrays;

public class HeapSortExample {
    public static void main(String[] args) {
        int[] tasks = {5, 2, 8, 3, 7, 1, 4}; // Приоритеты задач
        System.out.println("До сортировки: " + Arrays.toString(tasks));

        sortTasksByPriority(tasks);

        System.out.println("После сортировки: " + Arrays.toString(tasks));
    }

    public static void sortTasksByPriority(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int heapSize, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != root) {
            swap(arr, root, largest);
            heapify(arr, heapSize, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

