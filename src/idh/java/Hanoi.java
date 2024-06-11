package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Hanoi {

    private Stack<Integer> left;
    private Stack<Integer> middle;
    private Stack<Integer> right;

    public Hanoi() {
        left = new Stack<>();
        middle = new Stack<>();
        right = new Stack<>();
        
        for (int i = 9; i >= 1; i--) {
            left.push(i);
        }
    }

    private void movePiece(char from, char to) {
        Stack<Integer> source;
        Stack<Integer> target;

        switch (from) {
            case 'l': source = left; break;
            case 'm': source = middle; break;
            case 'r': source = right; break;
            default: throw new IllegalArgumentException("Invalid source stick: " + from);
        }

        switch (to) {
            case 'l': target = left; break;
            case 'm': target = middle; break;
            case 'r': target = right; break;
            default: throw new IllegalArgumentException("Invalid target stick: " + to);
        }

        if (!source.isEmpty() && (target.isEmpty() || source.peek() < target.peek())) {
            target.push(source.pop());
        } else {
            System.out.println("Illegal move. Try again.");
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
                // e.printStackTrace();
            }
        }
    }

    private Iterator<Integer> getLeftDescendingIterator() {
        return getDescendingIterator(left);
    }

    private Iterator<Integer> getMiddleDescendingIterator() {
        return getDescendingIterator(middle);
    }

    private Iterator<Integer> getRightDescendingIterator() {
        return getDescendingIterator(right);
    }

    private Iterator<Integer> getDescendingIterator(Stack<Integer> stack) {
        List<Integer> list = new ArrayList<>(stack);
        Collections.reverse(list);
        return list.iterator();
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
