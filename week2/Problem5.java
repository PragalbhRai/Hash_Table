import java.util.*;

public class Problem5 {

    // Linear Search
    static int linearSearch(String[] arr, String target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear comparisons: " + comparisons);
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1, comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                System.out.println("Binary comparisons: " + comparisons);
                return mid;
            }
            else if (arr[mid].compareTo(target) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // Count occurrences
    static int countOccurrences(String[] arr, String target) {
        int count = 0;
        for (String s : arr)
            if (s.equals(target)) count++;
        return count;
    }

    public static void main(String[] args) {
        String[] logs = {"accA", "accB", "accB", "accC"};

        Arrays.sort(logs);

        System.out.println("Linear index: " + linearSearch(logs, "accB"));
        System.out.println("Binary index: " + binarySearch(logs, "accB"));
        System.out.println("Count: " + countOccurrences(logs, "accB"));
    }
}