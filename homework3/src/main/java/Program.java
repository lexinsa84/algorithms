package main.java;

public class Program {
    public static void main(String[] args) {
        List list = new List();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(4);
        list.addLast(1);
        list.addLast(5);

        System.out.println("До удаления дубликатов:");
        list.printList();

        list.removeDuplicates();

        System.out.println("После удаления дубликатов:");
        list.printList();

        Node middle = list.findMiddle();
        if (middle != null) {
            System.out.println("Средний элемент: " + middle.data);
        } else {
            System.out.println("Список пуст.");
        }
        List list2 = new List();
        list2.addLast(2);
        list2.addLast(6);
        list2.addLast(7);

        System.out.println("Первый список:");
        list.printList();

        System.out.println("Второй список:");
        list2.printList();

        List mergedList = List.mergeSortedLists(list, list2);

        System.out.println("Слияние двух списков:");
        mergedList.printList();
    }
}
