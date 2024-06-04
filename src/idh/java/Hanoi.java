package idh.java;

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Deque;

public class Hanoi {
	//linker Turm
	Deque<Integer> towerL;
	//mittlerer Turm
	Deque<Integer> towerM;
	//rechter Turm
	Deque<Integer> towerR;
	
	public Hanoi(int groesse) {
		// TODO: Implement
		towerL = new LinkedList<Integer>();
		towerM = new LinkedList<Integer>();
		towerR = new LinkedList<Integer>();
		
		for(int i = groesse; i > 0; i--) {
			towerL.addFirst((Integer) i);
		}
	}
	
	private void movePiece(char from, char to) {
		// TODO: Implement
		if(from == 'l') {
			if(!towerL.isEmpty()) {
				if(to == 'm') {
					if(towerM.isEmpty() || towerL.getFirst() < towerM.getFirst()) {
						towerM.addFirst(towerL.removeFirst());
					}
				}
				if(to == 'r') {
					if(towerR.isEmpty() || towerL.getFirst() < towerR.getFirst()) {
						towerR.addFirst(towerL.removeFirst());
					}
				}
			}
		}
		
		if(from == 'm') {
			if(!towerM.isEmpty()) {
				if(to == 'l') {
					if(towerL.isEmpty() || towerM.getFirst() < towerL.getFirst()) {
						towerL.addFirst(towerM.removeFirst());
					}
				}
				if(to == 'r') {
					if(towerR.isEmpty() || towerM.getFirst() < towerR.getFirst()) {
						towerR.addFirst(towerM.removeFirst());
					}
				}
			}
		}
		
		if(from == 'r') {
			if(!towerR.isEmpty()) {
				if(to == 'l') {
					if(towerL.isEmpty() || towerR.getFirst() < towerL.getFirst()) {
						towerL.addFirst(towerR.removeFirst());
					}
				}
				if(to == 'm') {
					if(towerM.isEmpty() || towerR.getFirst() < towerM.getFirst()) {
						towerM.addFirst(towerR.removeFirst());
					}
				}
			}
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
		return towerL.descendingIterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		return towerM.descendingIterator();
	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		return towerR.descendingIterator();
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
		Hanoi hanoi = new Hanoi(9);
		hanoi.run();
	}

}
