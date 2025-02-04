package main.java.lists;

public class DoublyList {
    Node head;
    Node tail;

    // Добавление элемента в начало списка
    void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Добавление элемента в конец списка
    void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Удаление первого элемента списка
    void removeFirst() {
        if (head == null) return;
        if (head == tail) { // Один элемент в списке
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Удаление последнего элемента списка
    void removeLast() {
        if (tail == null) return;
        if (head == tail) { // Один элемент в списке
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Поиск элемента в списке
    boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    void sort() {
        if (head == null || head.next == null) {
            return; // Уже отсортирован
        }

        Node current = head.next; // Начинаем с 2-го элемента
        while (current != null) {
            Node key = current;
            Node previous = current.prev;

            while (previous != null && previous.data > key.data) {
                // Обмен значениями (без перестановки узлов)
                int temp = previous.data;
                previous.data = key.data;
                key.data = temp;

                key = previous;  // Сдвигаем указатель назад
                previous = previous.prev;
            }
            current = current.next;
        }
    }

    // Вывод списка (прямой порядок)
    void printForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Вывод списка (обратный порядок)
    void printBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) {
                System.out.print(" <-> ");
            }
            current = current.prev;
        }
        System.out.println();
    }
}
