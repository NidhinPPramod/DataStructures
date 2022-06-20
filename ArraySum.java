public class ArraySum {

    public static int[] twoNumberSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] { arr[i], arr[j] };
                }
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
