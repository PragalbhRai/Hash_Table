import java.util.*;

public class PlagiarismDetector {

    HashMap<String, Set<String>> ngrams = new HashMap<>();

    public List<String> extractNgrams(String text, int n) {

        String[] words = text.split(" ");
        List<String> result = new ArrayList<>();

        for (int i = 0; i <= words.length - n; i++) {
            String gram = String.join(" ", Arrays.copyOfRange(words, i, i + n));
            result.add(gram);
        }

        return result;
    }

    public void addDocument(String docId, String text) {

        List<String> grams = extractNgrams(text, 3);

        for (String g : grams) {
            ngrams.putIfAbsent(g, new HashSet<>());
            ngrams.get(g).add(docId);
        }
    }

    public static void main(String[] args) {

        PlagiarismDetector pd = new PlagiarismDetector();

        pd.addDocument("doc1", "this is a sample document text");
        pd.addDocument("doc2", "this is a sample essay text");

        System.out.println("Documents indexed.");
    }
}