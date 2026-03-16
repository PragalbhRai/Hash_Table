import java.util.*;

public class TwoSumTransactions {

    public static void twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {

            int complement = target - num;

            if (map.containsKey(complement)) {
                System.out.println("Pair: " + num + " + " + complement);
            }

            map.put(num, 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {500,300,200};

        twoSum(nums,500);
    }
}