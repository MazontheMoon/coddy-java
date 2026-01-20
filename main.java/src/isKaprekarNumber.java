import java.util.ArrayList;
import java.util.List;

class FindKaprekarNumbers {
    public static String[][] findKaprekarNumbers(int start, int end) {
        List<String[]> result = new ArrayList<>();

        for (int num = start; num <= end; num++) {
            if (isKaprekarNumber(num)) {
                String decimal = String.valueOf(num);
                String binary = Integer.toBinaryString(num);
                result.add(new String[]{decimal, binary});
            }
        }

        return result.toArray(new String[0][]);
    }

    private static boolean isKaprekarNumber(int num) {
        long square = (long) num * num;
        String squareStr = String.valueOf(square);
        int length = squareStr.length();

        if (length == 1) {
            return num == 1;
        }

        int rightPartLength = length / 2;
        int leftPartLength = length - rightPartLength;

        String leftPart = squareStr.substring(0, leftPartLength);
        String rightPart = squareStr.substring(leftPartLength);

        int leftNum = leftPart.isEmpty() ? 0 : Integer.parseInt(leftPart);
        int rightNum = rightPart.isEmpty() ? 0 : Integer.parseInt(rightPart);

        return leftNum + rightNum == num;
    }
}
