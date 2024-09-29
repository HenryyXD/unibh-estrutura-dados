package desafio_pilha;

import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma palavra para verificar se é palíndroma: ");
        String palavra = scanner.next();

        Stack<Character> stack = new Stack<>();
        for (char c : palavra.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindrome = true;
        for (char c : palavra.toCharArray()) {
            if (c != stack.pop())
                isPalindrome = false;
        }

        System.out.println((isPalindrome ? "É" : "Não é") + " palíndromo.");
    }
}
