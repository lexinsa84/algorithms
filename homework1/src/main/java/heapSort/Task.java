package main.java.heapSort;

public class Task {
    String description;
    int priority;

    Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task: " + description + ", Priority: " + priority;
    }
}
