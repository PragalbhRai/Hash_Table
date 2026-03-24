import java.util.*;

public class Problem6 {

    // Linear Search
    static boolean linearSearch(int[] arr, int target) {
        for (int x : arr)
            if (x == target) return true;
        return false;
    }

    // Binary Floor (largest ≤ target)
    static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // Binary Ceiling (smallest ≥ target)
    static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 50, 100};

        System.out.println("Linear found 30: " + linearSearch(arr, 30));
        System.out.println("Floor of 30: " + floor(arr, 30));
        System.out.println("Ceiling of 30: " + ceiling(arr, 30));
    }
}