package main.java.lists;

public class Program {
    public static void main(String[] args) {
        List list = new List();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.printList();
        list.removeFirst();
        list.removeFirst();
        list.printList();

        int searchValue = 2;
        System.out.println("Содержит " + searchValue + " ? " + list.contains(searchValue));

        searchValue = 5;
        System.out.println("Содержит " + searchValue + " ? " + list.contains(searchValue));

        list.printList();

        list.addLast(8);
        list.addLast(9);

        list.printList();
        list.removeLast();
        System.out.println("После удаления последнего элемента:");
        list.printList();

        DoublyList doublyList = new DoublyList();
        doublyList.addFirst(2);
        doublyList.addFirst(1);
        doublyList.addLast(3);
        doublyList.addLast(4);

        System.out.println("Прямой порядок:");
        doublyList.printForward();

        System.out.println("Обратный порядок:");
        doublyList.printBackward();

        doublyList.removeFirst();
        System.out.println("После удаления первого элемента:");
        doublyList.printForward();

        list.removeLast();
        System.out.println("После удаления последнего элемента:");
        doublyList.printForward();

        doublyList.addLast(4);
        doublyList.addLast(2);
        doublyList.addLast(5);
        doublyList.addLast(1);
        doublyList.addLast(3);

        System.out.println("До сортировки:");
        doublyList.printForward();

        doublyList.sort();

        System.out.println("После сортировки:");
        doublyList.printForward();
    }
}
