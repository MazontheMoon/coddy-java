import java.util.regex.Pattern;

class AnalyzeCountrysideLandmark {
    public static String analyzeCountrysideLandmark(String landmarkName, String mathExpression) {
        boolean isPalindrome = isPalindrome(landmarkName);
        int anagramValue = calculateAnagramValue(landmarkName);
        int expressionResult = evaluateExpression(mathExpression, anagramValue);
        boolean isPerfectSquare = isPerfectSquare(expressionResult);

        return String.format("Landmark: %s\nPalindrome: %b\nAnagram Value: %d\nExpression Result: %d\nPerfect Square: %b",
                landmarkName, isPalindrome, anagramValue, expressionResult, isPerfectSquare);
    }

    private static boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    private static int calculateAnagramValue(String s) {
        return s.chars().filter(Character::isLetter).map(Character::toLowerCase).sum();
    }

    private static int evaluateExpression(String expression, int x) {
        expression = expression.replaceAll("x", Integer.toString(x));
        return (int) eval(expression);
    }

    private static double eval(String expression) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                return x;
            }
        }.parse();
    }

    private static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}