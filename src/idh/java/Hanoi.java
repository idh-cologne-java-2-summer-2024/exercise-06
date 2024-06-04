package idh.java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;


public class Hanoi {
	private LinkedList<Integer> l;
	private LinkedList<Integer> m;
	private LinkedList<Integer> r;
	
	public Hanoi() {
		l = new LinkedList<Integer>();
		m = new LinkedList<Integer>();
		r = new LinkedList<Integer>();
	
		for (int i = 1; i < 10; i++) {
			l.add(i);
			System.out.print(i + ", ");}
		System.out.println();
		System.out.println();}
	
	private void movePiece(char from, char to) {
		LinkedList<Integer> fromList = getListFromChar(from);
		LinkedList<Integer> toList = getListFromChar(to);
		if(!toList.isEmpty()){
			if(fromList.peekFirst() > toList.peekFirst()) {
				return;}}
		
		int first = fromList.poll();
		toList.addFirst(first);}
	
	private LinkedList<Integer> getListFromChar(char lmr){
		
		switch (lmr) {
		case 'l':
			return l;
		case 'm':
			return m;
		case 'r':
			return r;
		default:
			return null;}}
	
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
					movePiece(source, target);}
			} catch (Exception e) {
				System.out.println("Try again, something's not right.");
				e.printStackTrace();}}}
	
	private Iterator<Integer> getLeftDescendingIterator() {
		return l.descendingIterator();}
	private Iterator<Integer> getMiddleDescendingIterator() {
		return m.descendingIterator();}
	private Iterator<Integer> getRightDescendingIterator() {
		return r.descendingIterator();}
	
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("  |\n l|");
		Iterator<Integer> iter;
		iter = this.getLeftDescendingIterator();
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');}
		b.append("\n  |\n m|");
		iter = this.getMiddleDescendingIterator();
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');}
		b.append("\n  |\n r|");
		iter = this.getRightDescendingIterator();
		while(iter.hasNext()) {
			b.append(iter.next());
			b.append(' ');}
		b.append("\n  |");
		return b.toString();}
	
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		hanoi.run();}}