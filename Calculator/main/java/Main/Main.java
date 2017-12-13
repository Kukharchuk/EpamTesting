package Main;

import Calculator.Calculator;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите пример");
        String str = sc.nextLine();
        System.out.println(Calculator.eval(str));
    }
}