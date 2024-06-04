package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {

		// TODO: Implement
		private Stack<Integer> left;
	    private Stack<Integer> middle;
	    private Stack<Integer> right;

	    public Hanoi() {
	        // TODO: Implement
	        left = new Stack<>();
	        middle = new Stack<>();
	        right = new Stack<>();

	        // Fill the left stack with disks of size 9 to 1
	        for (int i = 9; i >= 1; i--) {
	            left.push(i);
	        }
	}
	
	private void movePiece(char from, char to) {
		// TODO: Implement
		Stack<Integer> source;
        Stack<Integer> target;

        // Determine the source and target stacks based on the input characters
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
                return;
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
                return;
        }

        // Perform the move if valid
        if (!source.isEmpty() && (target.isEmpty() || source.peek() < target.peek())) {
            target.push(source.pop());
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
		// TODO: Implement
		return left.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		return middle.iterator();
	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		return right.iterator();
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("  |\n l|");
		Iterator<Integer> iter;
		iter = this.getLeftDescendingIterator();
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n m|");
		iter = this.getMiddleDescendingIterator();
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');
		}
		b.append("\n  |\n r|");
		iter = this.getRightDescendingIterator();
		while(iter.hasNext()) {
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
