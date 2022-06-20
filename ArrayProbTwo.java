public class ArrayProbTwo {

    public static int[] sortedTwo(int[] arr, int target) {
        int j = arr.length - 1;
        int i = 0;
        while (i < j) {
            if (arr[j] == target) {
                j--;
            }
            if (arr[i] == target) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = { 6, 1, 6, 8, 10, 4, 15, 6, 3, 7, 6 };
        int key = 6;
        int[] result = sortedTwo(array, key);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
