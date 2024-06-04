package idh.java;
//TODO: IMPLEMENT ITERATORS, NOTHING WILL RUN BEFORE THAT
//TODO: Replace PriorityQueue with simple LinkedLists (or Dequeue?)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Hanoi {
	
	private LinkedList<Integer> l;
	private LinkedList<Integer> m;
	private LinkedList<Integer> r;

	public Hanoi() {
// TODO: Implement maybe create new disc class? scrap that
//		Disk Array from 1-9
//		Disk disks[] = new Disk[9];
//		int charCount = 30; //trying to get UInicode equivalents of numbers 1-9 /0030 --> 1, 0031 --> 2 etc. I don't think that this actually works
//		for(int i = 0; i<disks.length;i++) {
//			disks[i] = new Disk(0,"/00" + (char)charCount);
//			charCount++;
//		}
//		Queue<Disk>dq1 = new LinkedList<>(Arrays.asList(disks)); 
//		String gameState = this.toString();
		l = new LinkedList<Integer>();
		m = new LinkedList<Integer>();
		r = new LinkedList<Integer>();
		
		for (int i = 1; i < 10; i++) {
			l.add(i); //fill left stack with disks 1-9
		}
		
	}
	
	private void movePiece(char from, char to) {
		LinkedList<Integer> fromList = getListFromChar(from);
		LinkedList<Integer> toList = getListFromChar(to);
		
		if(!toList.isEmpty()) {
			if(fromList.peekFirst() > toList.peekFirst()) {
				return;
			}
		}
		
		
		int first = fromList.poll();
		toList.addFirst(first);
		
	}
	
	private LinkedList<Integer> getListFromChar(char lmr) {
		switch (lmr) {
		case 'l':
			return l;
		case'm':
			return m;
		case'r':
			return r;
		default:
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
				// [^...]--> find character NOT between brackets 
				// ^--> Find a match at the beginning of String, $--> find match at the end of the String
				if (s.matches("^([lmr])([lmr])$")) { 
					char source = s.charAt(0);
					char target = s.charAt(1);
					movePiece(source, target);
				}
			} catch (Exception e) {
				System.out.println("Try again, something's not right.");
				 e.printStackTrace();
				 System.exit(-1); //exits the program and prevents my PC from catching fire...
			} 
		}
	}
//	descending iterator is used for visual purposes 
	private Iterator<Integer> getLeftDescendingIterator() {
		return l.descendingIterator();

	}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return m.descendingIterator();

	}
	private Iterator<Integer> getRightDescendingIterator() {
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
		hanoi.run();
	}

}
