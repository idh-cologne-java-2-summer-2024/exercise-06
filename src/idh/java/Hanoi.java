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
			left = new Stack<>();
			middle = new Stack<>();
			right = new Stack<>();

			for (int i = 9; i >= 1; i--) {
				left.push(i);
			}
	}
	
	private void movePiece(char from, char to) {
		Stack<Integer> source = getStack(from);
		Stack<Integer> target = getStack(to);

		if (source.isEmpty()) {
			System.out.println("Der Quellstab ist leer, ungültiger Zug!");
			return;
		}

		int disk = source.pop();

		if (!target.isEmpty() && target.peek() < disk) {
			System.out.println("Ungültiger Zug: Eine größere Scheibe kann nicht auf einer kleineren liegen.");
			source.push(disk);  // Die Scheibe wieder zurücklegen
			return;
		}

		target.push(disk);
	}
	
	private Stack<Integer> getStack(char c) {
		switch (c) {
			case 'l': return left;
			case 'm': return middle;
			case 'r': return right;
			default: throw new IllegalArgumentException("Ungültiger Stab: " + c);
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
		return new DescendingIterator(left);

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return new DescendingIterator(middle);
	}
	private Iterator<Integer> getRightDescendingIterator() {
		return new DescendingIterator(right);
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
}
