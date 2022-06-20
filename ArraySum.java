// TimeComplexity:O(n^2)
// Spacecomplexity:O(1)

// public class ArraySum {

// public static int[] twoNumberSum(int[] arr, int target) {
// for (int i = 0; i < arr.length; i++) {
// for (int j = i + 1; j < arr.length; j++) {
// if (arr[i] + arr[j] == target) {
// return new int[] { arr[i], arr[j] };
// }
// }
// }
// return new int[0];
// }

// public static void main(String[] args) {
// int[] array = { 6, 4, 5, 2, 1 };
// int target = 10;
// int[] result = twoNumberSum(array, target);
// for (int i = 0; i < result.length; i++) {
// System.out.println(result[i]);
// }
// }
// }

//SpaceComplexity:O(n)
//TimeComplexity:O(n)
import java.util.*;

public class ArraySum {

    public static int[] twoNumberSum(int[] arr, int target) {

        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int match = target - num;
            if (nums.contains(match)) {
                return new int[] { num, match };
            } else {
                nums.add(num);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] array = { 6, 4, 5, 2, 1 };
        int target = 10;
        int[] result = twoNumberSum(array, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}