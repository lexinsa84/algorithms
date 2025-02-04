package main.java.lists;

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
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
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


    void printList(){
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
