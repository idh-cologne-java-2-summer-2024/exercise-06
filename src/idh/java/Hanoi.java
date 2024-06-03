package idh.java;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.ArrayList; 

public class Hanoi {

	public Hanoi() {
		
	Stack<Integer> l = new Stack <>();
	l.add(9);
	l.add(8);
	l.add(7);
	l.add(6);
	l.add(5);
	l.add(4);
	l.add(3);
	l.add(2);
	l.add(1);
	Stack<Integer> m = new Stack <>();
	Stack<Integer> r = new Stack <>();
		// TODO: Implement
	
	
	}
	
// Wenn ein Stab leer ist, kann nicht von ihm gezogen werden
// Ich muss sicher stellen, dass die Nummer, die gezogen wird, entweder auf ein leeren Platz oder einen 
// kleineren Platz passt
// Ich muss drei Stacks erstellen, mit den jeweiligen Namen. 
// es handelt sich hier um einen Stack, von daher erstmal erstellen, dass es drei Stück gibt. 
	private void movePiece(char from, char to) { 
	
		
		
		// sollte das Ergebnis des jweiligen Iterators sein, der in einen Int-Wert umgewandelt wird
		int ffrom = 0; 
		
		// sollte das Ergebnis des jewiligen Iterators sein, der in einen Int-Wert umgewandelt wird
		int tto= 12; 
		 
		
		switch (from) {
        case 'l':
             int k = l.peek();
             
           
        case 'm':
        	 getMiddleDescendingIterator();
        case 'r':
        	 getRightDescendingIterator();
        	}
		
		switch (to) {
		case 'l':
            getLeftDescendingIterator(); 
		case 'm':
       	 	getMiddleDescendingIterator();
		case 'r':
       	 	getRightDescendingIterator();
       	}
		
		if (from > to) {
			// move from to to 
		
		}
		
		
//peek (from, to) wenn bei to nichts ist, dann from nach to oder wenn bei to kleiner ist, als bei 
// from, dann from nach to 
// pop (from), push (to)
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
		Stack<Integer>l = new ArrayList<>();
		
		return null; 
	}
	

	
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: Implement
		return null;

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		return null;
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
