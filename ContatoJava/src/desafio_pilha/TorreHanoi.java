package desafio_pilha;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class TorreHanoi {
    public static final int ANIMATION_TIMER_MS = 20;
    public static final boolean SHOW_HISTORY = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número de discos: ");
        int n = scanner.nextInt();


        Stack<Integer> source = new Stack<>();
        Stack<Integer> target = new Stack<>();
        Stack<Integer> auxiliary = new Stack<>();

        for (int i = n; i > 0; i--) {
            source.push(i);
        }

        TowerPrinter towerPrinter = new TowerPrinter(source, auxiliary, target);
        towerPrinter.print();

        SolveHanoi(n, source, target, auxiliary, towerPrinter);
        System.out.println("\nTorre de origem: " + source);
        System.out.println("Torre auxiliar: " + auxiliary);
        System.out.println("Torre de destino: " + target);
    }

    public static void SolveHanoi(int n, Stack<Integer> source, Stack<Integer> target, Stack<Integer> auxiliary, TowerPrinter towerPrinter) {
        if (n == 0) return;
        SolveHanoi(n - 1, source, auxiliary, target, towerPrinter);
        target.push(source.pop());
        clearConsole();
        towerPrinter.print();
        SolveHanoi(n - 1, auxiliary, target, source, towerPrinter);
    }

    public static void clearConsole() {
        try {
            Thread.sleep(ANIMATION_TIMER_MS);
            if (SHOW_HISTORY) {
                Printer.write("\n".repeat(30));
                Printer.flush();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

class TowerPrinter {
    private final Stack<Integer> a;
    private final Stack<Integer> b;
    private final Stack<Integer> c;
    private final int NUMBER_OF_TOWERS = 3;
    private final String SPACE = " ";
    private final String SPACING_BETWEEN_TOWERS = SPACE.repeat(2);
    private final String DISC_SYMBOL = "O";
    private final String TOWER_SYMBOL = "|";
    private int maxTowerWidth;
    private int towerMaxSize;

    public TowerPrinter(Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
        this.a = a;
        this.b = b;
        this.c = c;
        towerMaxSize = Math.max(a.size(), Math.max(b.size(), c.size()));
        maxTowerWidth = getTowerWidth(towerMaxSize);
    }

    public void print() {
        Printer.writeln();

        // linha acima da torre
        Printer.writeln("-".repeat(maxTowerWidth * (NUMBER_OF_TOWERS + 1)));

        // topo da torre vazio
        Printer.writeln(printDiscOrSpaces(new Stack<>(), 0).repeat(NUMBER_OF_TOWERS));

        for (int level = towerMaxSize - 1; level >= 0; level--) {
            Printer.write(printDiscOrSpaces(a, level));
            Printer.write(printDiscOrSpaces(b, level));
            Printer.writeln(printDiscOrSpaces(c, level));
        }

        // linha abaixo da torre
        Printer.writeln("-".repeat(maxTowerWidth * (NUMBER_OF_TOWERS + 1)));

        String spacingBegin = SPACE.repeat(maxTowerWidth / 2);
        String spacingMiddle = spacingBegin + spacingBegin + SPACING_BETWEEN_TOWERS;
        Printer.writeln(spacingBegin + "A" + spacingMiddle + "B" + spacingMiddle + "C"); // nome das torres
        Printer.flush();
    }

    public String printDiscOrSpaces(Stack<Integer> stack, int level) {
        if (stack.size() > level) {
            int value = stack.get(level);
            int currentTowerWidth = getTowerWidth(value);
            String halfSpace = SPACE.repeat(getHalfMaxTowerWidth() - currentTowerWidth / 2);
            String disc = DISC_SYMBOL.repeat(currentTowerWidth);
            String discWithVerticalBar = disc.substring(0, currentTowerWidth / 2) + TOWER_SYMBOL + disc.substring(currentTowerWidth / 2 + 1);
            return halfSpace + discWithVerticalBar + halfSpace + SPACING_BETWEEN_TOWERS;
        }

        String halfSpace = SPACE.repeat(getHalfMaxTowerWidth());
        return halfSpace + TOWER_SYMBOL + halfSpace + SPACING_BETWEEN_TOWERS;
    }

    private int getTowerWidth(int discValue) {
        return (discValue + 1) * 2 - 1;
    }

    private int getHalfMaxTowerWidth() {
        return maxTowerWidth / 2;
    }
}

class Printer {
    public static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void write(String str) {
        try {
            bufferedWriter.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeln(String str) {
        write(str + "\n");
    }

    public static void writeln() {
        writeln("");
    }

    public static void flush() {
        try {
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
