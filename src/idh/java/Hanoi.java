package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Hanoi {
	private LinkedList<Integer> left;
	private LinkedList<Integer> middle;
	private LinkedList<Integer> right;
	private int moveCount; //Züge sollen gezählt werden

	public Hanoi() {
		left = new LinkedList<>();
		middle = new LinkedList<>();
		right = new LinkedList<>();
		moveCount = 0; // Züge anfangs auf 0 gesetzt zum zählen
		
		// Initialisierung der Stäbe: Scheiben 9 bis 1 auf dem linken Stab
        for (int i = 9; i >= 1; i--) {
            left.push(i);
        }
	}
	
	private void movePiece(char from, char to) {
		LinkedList<Integer> source = getRod(from);
		LinkedList<Integer> target = getRod(to);
		
		if (source.isEmpty()) {
			System.out.println("Source rod is empty.");
			return;
		}
		
		int piece = source.peek();
		if(!target.isEmpty()&& target.peek() <piece) {
			System.out.println("Cannot move a larger piece onto a smaller piece.");
			return;
		}
		
		source.pop();
		target.push(piece);
		moveCount++; // hochzählen der Züge
	}
	
	private LinkedList<Integer> getRod(char rod) {
		switch (rod ) {
		case 'l':
			return left;
		case 'm':
			return middle;
		case 'r':
			return right;
		default:
			throw new IllegalArgumentException("invalid rod: " + rod);
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
				} else {
					System.out.println("invalid input. Use 'l', 'm', or 'r' for source and target");
				}
			} catch (Exception e) {
				System.out.println("Try again, something's not right.");
				e.printStackTrace();
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
		b.append("\nMove count: ").append(moveCount); // hiermit werden die Züge gezählt
		return b.toString();
	}
	
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		hanoi.run();
	}

}
