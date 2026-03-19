import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SustainableSort {
    public static String[] sustainableSort(String[] items, int targetBase) {
        List<String> result = new ArrayList<>();

        for (String item : items) {
            if (isPalindrome(item)) {
                result.add("Reuse: " + item);
            } else if (containsEcoAnagram(item)) {
                result.add("Compost: " + item);
            } else if (containsNumber(item)) {
                int number = extractNumber(item);
                String convertedNumber = Integer.toString(number, targetBase);
                if (convertedNumber.length() > 2) {
                    result.add("Recycle: " + item);
                } else {
                    result.add("Landfill: " + item);
                }
            } else {
                result.add("Landfill: " + item);
            }
        }

        return result.toArray(new String[0]);
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean containsEcoAnagram(String s) {
        s = s.toLowerCase();
        int e = 0, c = 0, o = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'e') e++;
            else if (ch == 'c') c++;
            else if (ch == 'o') o++;
        }
        return e > 0 && c > 0 && o > 0;
    }

    private static boolean containsNumber(String s) {
        return s.matches(".*\\d+.*");
    }

    private static int extractNumber(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}