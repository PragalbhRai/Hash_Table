import java.util.*;

public class AutocompleteSystem {

    HashMap<String, Integer> queries = new HashMap<>();

    public void addQuery(String q) {
        queries.put(q, queries.getOrDefault(q, 0) + 1);
    }

    public List<String> search(String prefix) {

        List<String> result = new ArrayList<>();

        for (String q : queries.keySet()) {
            if (q.startsWith(prefix)) {
                result.add(q);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        AutocompleteSystem ac = new AutocompleteSystem();

        ac.addQuery("java tutorial");
        ac.addQuery("javascript course");

        System.out.println(ac.search("jav"));
    }
}