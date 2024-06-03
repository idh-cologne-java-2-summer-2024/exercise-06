package idh.java;

import java.util.Stack;

public class Hanoi {
    private Stack<Integer> left;
    private Stack<Integer> middle;
    private Stack<Integer> right;

    public Hanoi() {
        left = new Stack<>();
        middle = new Stack<>();
        right = new Stack<>();

        // Initialize the left stack with disks 9 to 1
        for (int i = 9; i >= 1; i--) {
            left.push(i);
        }
    }

    public void move(char from, char to) {
        Stack<Integer> source = getStack(from);
        Stack<Integer> destination = getStack(to);

        if (source.isEmpty()) {
            System.out.println("Invalid move: source stack is empty.");
            return;
        }

        if (!destination.isEmpty() && source.peek() > destination.peek()) {
            System.out.println("Invalid move: cannot place larger disk on top of smaller disk.");
            return;
        }

        destination.push(source.pop());
    }

    private Stack<Integer> getStack(char stack) {
        switch (stack) {
            case 'l': return left;
            case 'm': return middle;
            case 'r': return right;
            default: throw new IllegalArgumentException("Invalid stack: " + stack);
        }
    }

    public void print() {
        System.out.println("l|" + stackToString(left));
        System.out.println("m|" + stackToString(middle));
        System.out.println("r|" + stackToString(right));
    }

    private String stackToString(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        for (int disk : stack) {
            sb.append(disk).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Hanoi game = new Hanoi();
        game.print();
        
        // Example moves
        game.move('l', 'r');
        game.print();
        
        game.move('l', 'm');
        game.print();
        
        game.move('r', 'm');
        game.print();
    }
}
