package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	
	Stack<Integer> l = new Stack<>();
	Stack<Integer> m = new Stack<>();
	Stack<Integer> r = new Stack<>();

	public Hanoi() {
		this.l.push(8);
		this.l.push(7);
		this.l.push(6);
		this.l.push(5);
		this.l.push(4);
		this.l.push(3);
		this.l.push(2);
		this.l.push(1);
	}
	
	private void movePiece(char from, char to) {
		Stack<Integer> sourceStack = null;
		Stack<Integer> targetStack = null;
		int ring;
		
		switch (from) {
			case 'l':
				sourceStack = this.l;
				break;
			case 'm': 
				sourceStack = this.m;
				break;
			case 'r':
				sourceStack = this.r;
				break;
		}
		switch (to) {
			case 'l':
				targetStack = this.l;
				break;
			case 'm': 
				targetStack = this.m;
				break;
			case 'r':
				targetStack = this.r;
				break;
		}
		
		    if (!sourceStack.isEmpty()) {
		        ring = sourceStack.pop();
	
	        if ((targetStack.isEmpty() || ring < targetStack.peek())) {
	            targetStack.push(ring);
		            
	        } else {
	            sourceStack.push(ring);
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
		Iterator<Integer> iter = l.iterator();
		return iter;

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		Iterator<Integer> iter = m.iterator();
		return iter;

	}
	private Iterator<Integer> getRightDescendingIterator() {
		Iterator<Integer> iter = r.iterator();
		return iter;
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
