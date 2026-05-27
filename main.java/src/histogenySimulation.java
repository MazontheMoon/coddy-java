import java.util.HashMap;
import java.lang.Math;

class HistogenySimulation {
    public static String histogenySimulation(String[] expertNumbers, String[] operations, int iterations, String initialBase, String finalBase) {
        HashMap<String, Double> constants = new HashMap<>();
        constants.put("e", 2.71828);
        constants.put("π", 3.14159);
        constants.put("φ", 1.61803);

        double[] numbers = new double[expertNumbers.length];
        for (int i = 0; i < expertNumbers.length; i++) {
            numbers[i] = convertToDecimal(expertNumbers[i], initialBase);
        }

        double result = numbers[0];
        for (int i = 0; i < iterations; i++) {
            for (String operation : operations) {
                result = applyOperation(result, operation, constants);
            }
        }

        return convertFromDecimal(result, finalBase);
    }

    private static double convertToDecimal(String number, String base) {
        switch (base) {
            case "binary":
                return Integer.parseInt(number, 2);
            case "octal":
                return Integer.parseInt(number, 8);
            case "decimal":
                return Double.parseDouble(number);
            case "hexadecimal":
                return Integer.parseInt(number, 16);
            default:
                return 0;
        }
    }

    private static String convertFromDecimal(double number, String base) {
        long roundedNumber = Math.round(number);
        switch (base) {
            case "binary":
                return Long.toBinaryString(roundedNumber);
            case "octal":
                return Long.toOctalString(roundedNumber);
            case "decimal":
                return String.valueOf(number);
            case "hexadecimal":
                return Long.toHexString(roundedNumber);
            default:
                return "";
        }
    }

    private static double applyOperation(double number, String operation, HashMap<String, Double> constants) {
        switch (operation) {
            case "sin":
                return Math.sin(number);
            case "cos":
                return Math.cos(number);
            case "tan":
                return Math.tan(number);
            case "log":
                return Math.log(number);
            case "xor":
                long longNumber = Math.round(number);
                long xorResult = longNumber ^ Math.round(constants.get("e"));
                return (double) xorResult;
            default:
                return number;
        }
    }
}
