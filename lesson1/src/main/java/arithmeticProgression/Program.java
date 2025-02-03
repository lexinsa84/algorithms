package main.java.arithmeticProgression;

import java.util.Scanner;

public class Program {

    private static long arithmeticProgression(int num) {
        return (long) num * (num + 1) / 2;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите число от 1 до 1 000 000");
            int n = scanner.nextInt();
            if (n < 1 || n > 1_000_000) {
                throw new IllegalArgumentException("Число должно быть в диапазоне от 1 до 1 000 000");
            }

            long sum = arithmeticProgression(n);
            System.out.println("Сумма равна " + sum);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

