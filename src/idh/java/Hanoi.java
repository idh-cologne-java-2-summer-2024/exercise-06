package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	
	private Stack<Integer> left;
    private Stack<Integer> middle;
    private Stack<Integer> right;
    
	public Hanoi() {
		// TODO: Implement
		 left = new Stack<>();
	     middle = new Stack<>();
	     right = new Stack<>();
	     
	     // Ausgangslage: links alle Scheiben stacken
	     for (int i = 9; i >= 1; i--) {
	            left.push(i);
	        }
	}
	
	private void movePiece(char from, char to) {
		// TODO: Implement -- prüft Gültigkeit
		Stack<Integer> source = null;
		Stack<Integer> target = null;

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
		}

		if (source != null && target != null && !source.isEmpty()) {
			int piece = source.peek();
			if (target.isEmpty() || piece < target.peek()) {
				target.push(source.pop());
			} else {
				System.out.println("Dat geht nicht! Regel Nr. 1: niemals größere auf kleinere Scheiben.");
			}
		} else {
			System.out.println("Der Stab war leider leer. Probiers nochmal woanders!");
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
