package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Hanoi {
	
	private Stack<Integer> l;
	
	private Stack<Integer> m;
	
	private Stack<Integer> r;
	
	private class DescendingIterator implements Iterator<Integer> {
		private final Stack<Integer> stack;
		private int currentIndex;

		public DescendingIterator(Stack<Integer> stack) {
			this.stack = stack;
			this.currentIndex = stack.size() - 1;
		}

		@Override
		public boolean hasNext() {
			return currentIndex >= 0;
		}

		@Override
		public Integer next() {
			return stack.get(currentIndex--);
		}
	}

	public Hanoi() {
		l = new Stack<Integer>();
		m = new Stack<Integer>();
		r = new Stack<Integer>();
	
		for (int i = 9; i >= 1; i--) {
			l.push(i);
			System.out.print(i + ", ");}
		System.out.println();
		System.out.println();
	}
	
	private void movePiece(char from, char to) {
		Stack<Integer> fromT = getStack(from) ; 
		Stack<Integer> toT = getStack(to);
		int plate = 0;
		
		
		if (fromT.isEmpty()) {
			System.out.println("There are not plates left on this tower");
			
		} else if (!fromT.isEmpty() && toT.peek() < plate) {
			System.out.println("You cannot place a bigger plate on a smaller one. Try again.");
				
		} else {
			plate = fromT.pop();
			toT.push(plate);
		}

	}
	
	private Stack<Integer> getStack(char tower) {
		switch (tower) {
			case 'l': return l;
			case 'm': return m;
			case 'r': return r;
			default: System.out.println("This tower is not available");
			return null;
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
		
		return new DescendingIterator(m);

	}
	
	private Iterator<Integer> getMiddleDescendingIterator() {
		
		return new DescendingIterator(m);
	}
	
	private Iterator<Integer> getRightDescendingIterator() {
		
		return new DescendingIterator(r);
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
