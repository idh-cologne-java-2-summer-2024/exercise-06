package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Hanoi {
    private final Deque<Integer> left, middle, right;

    public Hanoi() {
        // Initialisierung der Datenstruktur
        left = new ArrayDeque<>();
        middle = new ArrayDeque<>();
        right = new ArrayDeque<>();

        // Anfangssituation: Scheiben der Größen 9 bis 1 auf dem linken Stab
        for (int i = 9; i >= 1; i--) {
            left.addLast(i);
        }
    }

    private void movePiece(char from, char to) {
        Deque<Integer> source, target;

        // Bestimmen der Quell- und Zielstäbe basierend auf der Eingabe
        switch (from) {
            case 'l':
                source = left;
                break;
            case 'm':
                source = middle;
                break;
            case 'r':
                source = right;
                break;
            default:
                throw new IllegalArgumentException("Ungültige Eingabe für Quellstab");
        }

        switch (to) {
            case 'l':
                target = left;
                break;
            case 'm':
                target = middle;
                break;
            case 'r':
                target = right;
                break;
            default:
                throw new IllegalArgumentException("Ungültige Eingabe für Zielstab");
        }

        // Überprüfen, ob der Zug gültig ist
        if (!source.isEmpty() && (target.isEmpty() || source.peekFirst() < target.peekFirst())) {
            // Gültiger Zug: Oberste Scheibe vom Quellstab auf den Zielstab legen
            target.addFirst(source.removeFirst());
        } else {
            System.out.println("Ungültiger Zug!");
        }
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println(this);
                System.out.print("Enter source and target stick (will move top piece):");
                String s = br.readLine();
                if (s.matches("^([lmr])([lmr])$")) {
                    char source = s.charAt(0);
                    char target = s.charAt(1);
                    movePiece(source, target);
                }
            } catch (Exception e) {
                System.out.println("Try again, something's not right.");
            }
        }
    }

    private Iterator<Integer> getLeftDescendingIterator() {
        return left.descendingIterator();
    }

    private Iterator<Integer> getMiddleDescendingIterator() {
        return middle.descendingIterator();
    }

    private Iterator<Integer> getRightDescendingIterator() {
        return right.descendingIterator();
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("  |\n l|");
        Iterator<Integer> iter;
        iter = this.getLeftDescendingIterator();
        while (iter.hasNext()) {
            b.append(iter.next());
            b.append(' ');
        }
        b.append("\n  |\n m|");
        iter = this.getMiddleDescendingIterator();
        while (iter.hasNext()) {
            b.append(iter.next());
            b.append(' ');
        }
        b.append("\n  |\n r|");
        iter = this.getRightDescendingIterator();
        while (iter.hasNext()) {
            b.append(iter.next());
            b.append(' ');
        }
        b.append("\n  |");
        return b.toString();
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.run();
    }
}

