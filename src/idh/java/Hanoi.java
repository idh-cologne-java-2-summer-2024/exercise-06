package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Hanoi {
	
	Deque<Integer> leftPole;
	Deque<Integer> middlePole;
	Deque<Integer> rightPole;

	public Hanoi() {
		// DONE: Implement
		leftPole = new LinkedList<>();
		middlePole = new LinkedList<>();
		rightPole = new LinkedList<>();
		
		for(int i = 1; i < 10; i++) {
			leftPole.addLast(i);
		}
	}
	
	private void movePiece(char from, char to) {
		// TODO: Implement
		int movedPiece = 0;
		String emptyMessage = "The pole seems to be empty. Try again.";
		String largerOntoSmallerMessage = "You can't move a larger piece onto a smaller one. Try again";
		
		//System.out.println(middlePole.getFirst());
		
		if (from == 'l') {
			if (leftPole.getFirst() != null) {
				movedPiece = leftPole.removeFirst();
			} else {
				System.out.println(emptyMessage);
			}
		} else if (from == 'm') {
			if (middlePole.getFirst() != null) {
				movedPiece = middlePole.removeFirst();
			} else {
				System.out.println(emptyMessage);
			}
		} else if (from == 'r') {
			if (rightPole.getFirst() != null) {
				movedPiece = rightPole.removeFirst();
			} else {
				System.out.println(emptyMessage);
			}
		} else {
			System.out.println("Error: Hanoi has fallen! (from)");
		}
		
		
		if (to == 'l') {
			if (leftPole.isEmpty()) {
				leftPole.addFirst(movedPiece);
			} else if (leftPole.getFirst() > movedPiece) {
				leftPole.addFirst(movedPiece);
			} else {
				System.out.println(largerOntoSmallerMessage);
			}
		} else if (to == 'm') {
			if (middlePole.isEmpty()) {
					middlePole.addFirst(movedPiece);
			} else if (middlePole.getFirst() > movedPiece) {
					middlePole.addFirst(movedPiece);
			} else {
				System.out.println(largerOntoSmallerMessage);
			}
		} else if (to == 'r') {
			if (rightPole.isEmpty()) {
					rightPole.addFirst(movedPiece);
			} else if (rightPole.getFirst() > movedPiece) {
					rightPole.addFirst(movedPiece);
			} else {
				System.out.println(largerOntoSmallerMessage);
			}
		} else {
			System.out.println("Error: Hanoi has fallen! (to)");
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
				e.printStackTrace();
			} 
		}
	}
	
	private Iterator<Integer> getLeftDescendingIterator() {
		// DONE: Implement
		return leftPole.descendingIterator() ;

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		// DONE: Implement
		return middlePole.descendingIterator() ;

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// DONE: Implement
		return rightPole.descendingIterator();
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
