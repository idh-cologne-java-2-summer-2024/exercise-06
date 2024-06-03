package idh.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Document implements Iterable<String> {
    private List<String> lines;

    public Document(String filePath) throws IOException {
        lines = Files.readAllLines(Paths.get(filePath));
    }

    @Override
    public Iterator<String> iterator() {
        return new TokenIterator(lines);
    }

    public double ttr() {
        Set<String> types = new HashSet<>();
        int tokens = 0;

        for (String token : this) {
            types.add(token);
            tokens++;
        }

        return tokens == 0 ? 0 : (double) types.size() / tokens;
    }

    public static void main(String[] args) throws IOException {
        Document doc = new Document("data/dracula.txt");
        System.out.println("TTR: " + doc.ttr());
    }
}

class TokenIterator implements Iterator<String> {
    private Iterator<String> lineIterator;
    private Iterator<String> wordIterator;

    public TokenIterator(List<String> lines) {
        this.lineIterator = lines.iterator();
        this.wordIterator = List.of().iterator();  // Initialize with an empty iterator
    }

    @Override
    public boolean hasNext() {
        return wordIterator.hasNext() || lineIterator.hasNext();
    }

    @Override
    public String next
