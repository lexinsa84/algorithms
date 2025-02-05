package main.java;

import java.util.HashSet;

public class List {
    Node head;

    void addFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    void removeFirst(){
        if (head!=null)
            head=head.next;
    }

    void addLast(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    void removeLast() {
        if (head == null) {
            return; // Список пуст
        }
        if (head.next == null) {
            head = null; // В списке только один элемент
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    void removeDuplicates() {
        if (head == null) return;

        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (seen.contains(current.data)) {
                prev.next = current.next; // Удаляем текущий узел
            } else {
                seen.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

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

    Node findMiddle() {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Двигаемся на 1 шаг
            fast = fast.next.next; // Двигаемся на 2 шага
        }

        return slow; // slow окажется в середине списка
    }

    static List mergeSortedLists(List list1, List list2) {
        List mergedList = new List();
        Node dummy = new Node(0); // Временный узел
        Node tail = dummy;

        Node l1 = list1.head;
        Node l2 = list2.head;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Добавляем оставшиеся элементы
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }

        mergedList.head = dummy.next;
        return mergedList;
    }

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
