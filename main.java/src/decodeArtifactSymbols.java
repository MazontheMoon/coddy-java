import java.util.HashMap;

class DecodeArtifactSymbols {
    public static String decodeArtifactSymbols(int decimal, int operation) {
        String[] symbols = {"@", "#", "$", "%", "&", "*", "+"};
        HashMap<Integer, String> symbolMap = new HashMap<>();
        for (int i = 0; i < symbols.length; i++) {
            symbolMap.put(i, symbols[i]);
        }

        StringBuilder base7 = new StringBuilder();
        while (decimal > 0) {
            base7.insert(0, symbolMap.get(decimal % 7));
            decimal /= 7;
        }
        if (base7.length() == 0) {
            base7.append("@");
        }

        base7.reverse();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < base7.length(); i++) {
            int index = -1;
            for (int j = 0; j < symbols.length; j++) {
                if (symbols[j].equals(String.valueOf(base7.charAt(i)))) {
                    index = j;
                    break;
                }
            }

            if (operation == 0) {
                index = (index + 1) % 7;
            } else if (operation == 1) {
                index = (index - 1 + 7) % 7;
            }

            result.append(symbols[index]);
        }

        return result.toString();
    }
}