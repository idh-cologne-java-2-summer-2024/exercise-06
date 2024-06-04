package idh.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Document implements Iterable<String> {
	String documentText;

	public static Document readFromFile(File f) throws IOException {
		FileReader fileReader = new FileReader(f);
		int ch;
		StringBuilder b = new StringBuilder();
		while( (ch = fileReader.read()) != -1 ) {
			b.append((char) ch);
		}
		fileReader.close();
		Document doc = new Document();
		doc.documentText = b.toString();
		
		return doc;
	}
	
	public String getDocumentText() {
		return documentText;
	}

	public void setDocumentText(String documentText) {
		this.documentText = documentText;
	}
	
	public static final void main(String[] args) throws IOException {
		Document d = Document.readFromFile(new File("data/dracula.txt"));
		int i = 0;
		LinkedList<String> tokenL = new LinkedList<>();
		Set<String> TypesS = new HashSet<>();
		for (String token : d) {
			System.out.println(i++ + ": " + token + " ");
			tokenL.add(token);
			TypesS.add(token);
		}
		System.out.println(TypesS.size());
		System.out.println(tokenL.size());
		System.out.println(ttr(tokenL, TypesS));
	}

	private static double ttr(LinkedList<String> tokenL, Set<String> typesS) {
		double typesCount = (double) typesS.size();
		double tokenCount = (double) tokenL.size();
		double ttr = typesCount / tokenCount;
		
		return ttr;
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {

			StringTokenizer tokenizer = new StringTokenizer(documentText);
			
			@Override
			public boolean hasNext() {
				return tokenizer.hasMoreTokens();
			}

			@Override
			public String next() {
				return tokenizer.nextToken();
			}
			
		};
	}
	
	
}
