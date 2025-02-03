package main.java.findPrimeNumbers;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        System.out.println("Введите число от 2 до 1000");
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            if (n < 2 || n > 1000) {
                throw new IllegalArgumentException("Число должно быть в диапазоне от 2 до 1000");
            }
            searchForPrimeNumbers(n);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void searchForPrimeNumbers(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
