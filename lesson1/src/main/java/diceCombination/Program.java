package main.java.diceCombination;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество граней: ");
        int n = scanner.nextInt();
        System.out.println("Введите количество кубиков: ");
        int k = scanner.nextInt();
        System.out.println("Количество комбинаций: " + diceCombinationsFixed(n));
        System.out.println("Количество комбинаций: " + countCombinations(k, n));

    }

    public static int diceCombinationsFixed(int n) {
        int count = 0;

        for (int d1 = 1; d1 <= n; d1++) {
            for (int d2 = 1; d2 <= n; d2++) {
                for (int d3 = 1; d3 <= n; d3++) {
                    for (int d4 = 1; d4 <= n; d4++) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static long countCombinations(int k, int n) {
        if (k == 1) return n;
        return n * countCombinations(k - 1, n);
    }
}
