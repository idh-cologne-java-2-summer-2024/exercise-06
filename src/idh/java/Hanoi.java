package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

public class Hanoi {
	
	//linked lists
	private LinkedList<Integer> l; //muss noch importieren
	private LinkedList<Integer> m; 
	private LinkedList<Integer> r; 
	

	public Hanoi() {
		// TODO: Implement
		l = new LinkedList<Integer>(); //füllt deklaration von oben
		m = new LinkedList<Integer>();
		r = new LinkedList<Integer>();
	
		for (int i=1; i<10;i++) {
			l.add(i); //von 1 bis 9 sachen in die liste eingetragen und durch decending umgedreht
		}
	}
	
	private void movePiece(char from, char to) {
		// TODO: Implement
		LinkedList<Integer>fromList = getlistFromChar(from);
		LinkedList<Integer> toList = getlistFromChar(to);
		
		//if (fromList.isEmpty()) {
		//	return;
		//}
		
		if(!toList.isEmpty()) {
		    if(fromList.peekFirst() > toList.peekLast()) {
			    System.out.println(" Not possible!");
		    	return;
		    } //peelfirst nur erstes element wir angeschaut  
		}
		
		int first = fromList.poll(); //gibt das erste element und löscht es gleichteitig raus 
		//liegt aber noch in first 
		toList.addFirst(first);
		
	}
	
	
	private LinkedList<Integer> getlistFromChar(char lmr){
		switch (lmr) { //switch case statment
		case 'l':
			return l;
		case 'm':
			return m;
		case 'r': 
			return r;
		default:
			return null;
			
		}
	}
	
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.println(this); //rep des objektes wird in der konsole ausgegeben
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
		// TODO: Implement
		
		return l.descendingIterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		// TODO: ImplementS
		return m.descendingIterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
		// TODO: Implement
		return r.descendingIterator();
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
		hanoi.run(); //führ run methode aus 
	}

}
