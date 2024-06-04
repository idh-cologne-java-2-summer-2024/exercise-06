package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;


public class Hanoi {
	Stack <Integer> left;
	Stack <Integer> middle; 
	Stack <Integer> right; 
	
	public Hanoi() {
		left= new Stack <Integer>(); 
		middle= new Stack <Integer>();
		right= new Stack <Integer>();
		
			for(int i = 9; i>=1; i--) {
				left.push(i);
			}
	}
	
	private void movePiece(char from, char to) {
		Stack <Integer> source= getStack(from); 
		Stack <Integer> target= getStack(to);
		
		if (target.empty()||source.peek()<target.peek()) {
			target.push(source.pop());
		}
		
		if (this.left.empty() && this.middle.empty() && this.right.peek()==1) {
			System.out.println("You've won 🎆🎉🎊");
		}
	}
	
	private Stack <Integer> getStack(char input){

		if(input=='l') {
			return this.left;
		}
		else if (input=='m') {
			return this.middle;
		}
		else if (input=='r') {
			return this.right;
		}
		else 
			throw new IllegalArgumentException("Input is wrong");
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
		
		return this.left.iterator();
	}
	
	private Iterator<Integer> getMiddleDescendingIterator() {
		
		return this.middle.iterator();

	}
	
	private Iterator<Integer> getRightDescendingIterator() {
		
		return this.right.iterator();
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
