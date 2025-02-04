package main.java.heapSort;

public class HeapSortExample {

    public static void sortTasksByPriority(Task[] tasks) {
        int n = tasks.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(tasks, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            Task temp = tasks[0];
            tasks[0] = tasks[i];
            tasks[i] = temp;

            heapify(tasks, i, 0);
        }
    }

    private static void heapify(Task[] tasks, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && tasks[left].priority > tasks[largest].priority) {
            largest = left;
        }

        if (right < n && tasks[right].priority > tasks[largest].priority) {
            largest = right;
        }

        if (largest != i) {
            Task swap = tasks[i];
            tasks[i] = tasks[largest];
            tasks[largest] = swap;

            heapify(tasks, n, largest);
        }
    }

    public static void main(String[] args) {
        Task[] tasks = {
                new Task("Task 1", 4),
                new Task("Task 2", 3),
                new Task("Task 3", 5),
                new Task("Task 4", 2),
                new Task("Task 5", 1)
        };

        System.out.println("Before sorting:");
        for (Task task : tasks) {
            System.out.println(task);
        }

        sortTasksByPriority(tasks);

        System.out.println("\nAfter sorting:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
