import java.util.Arrays;

class AnalyzeFossilSequence {
    public static int[] analyzeFossilSequence(int[] fossilAges, int targetAge) {
        for (int i = 0; i < fossilAges.length; i++) {
            if (fossilAges[i] > targetAge) {
                reverseSubarray(fossilAges, i, fossilAges.length - 1);
            } else if (fossilAges[i] == targetAge) {
                reverseSubarray(fossilAges, 0, i);
            }
        }
        reverseSubarray(fossilAges, 0, fossilAges.length - 1);
        return fossilAges;
    }

    private static void reverseSubarray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
