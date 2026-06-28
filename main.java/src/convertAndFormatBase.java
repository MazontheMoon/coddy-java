import java.util.HashMap;
import java.util.Map;

class ConvertAndFormatBase {
    public static String convertAndFormatBase(String originalNumber, int originalBase, int targetBase) {
        if (originalBase < 2 || originalBase > 36 || targetBase < 2 || targetBase > 36) {
            return "Invalid input";
        }

        try {
            int decimalValue = Integer.parseInt(originalNumber, originalBase);
            String convertedNumber = Integer.toString(decimalValue, targetBase).toUpperCase();

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < convertedNumber.length(); i++) {
                char digit = convertedNumber.charAt(i);
                result.append(digit).append(" ").append(String.valueOf(digit).repeat(getOrdinalValue(digit))).append(" ");
            }

            return result.toString().trim();
        } catch (NumberFormatException e) {
            return "Invalid input";
        }
    }

    private static int getOrdinalValue(char digit) {
        if (Character.isDigit(digit)) {
            return digit - '0';
        } else {
            return digit - 'A' + 10;
        }
    }
}
