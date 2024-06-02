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
		
		for (int i = 9; i > 0; i--) {
			left.push(i);
		}
	}
	
	private Stack<Integer> getStack(char ch) throws Exception
	{
		switch (ch) {
		case 'l':
			return left;
		case 'm': 
			return middle;
		case 'r':
			return right;
		default:
			throw new Exception("input invalid");
		}

		
	}
	
	private void movePiece(char from, char to) throws Exception {
		Stack<Integer> source = getStack(from);
		Stack<Integer> target = getStack(to);
		
		target.push(source.pop());
		
		if (source.empty()) {
			throw new Exception ("stack is empty. choose another one");
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
		return left.iterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {

		return middle.iterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
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
