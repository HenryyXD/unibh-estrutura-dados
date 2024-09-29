package desafio_pilha;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class NumberBaseConversion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número inteiro (base 10): ");
        int number = scanner.nextInt();

        System.out.println("Digite a base para conversão: ");
        int base = scanner.nextInt();

        String digits = "0123456789ABCDEF";
        Stack<Object> stack = new Stack<>();
        while (number > 0) {
            stack.push(digits.charAt(number % base));
            number /= base;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println("Resultado: " + result);
    }

}
