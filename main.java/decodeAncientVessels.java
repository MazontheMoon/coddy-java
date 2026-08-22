import java.util.Arrays;

class DecodeAncientVessels {
    public static String[] decodeAncientVessels(String[] inscriptions, int key) {
        return Arrays.stream(inscriptions)
            .map(inscription -> decodeInscription(inscription, key))
            .toArray(String[]::new);
    }

    private static String decodeInscription(String inscription, int key) {
        StringBuilder reversed = new StringBuilder(inscription).reverse();
        StringBuilder decoded = new StringBuilder();

        for (char c : reversed.toString().toCharArray()) {
            if (c == 'z') break;

            int hash = (c - 'a' + 1) * key % 26;
            decoded.append(hash % 2 == 0 ? c : '.');
        }

        return decoded.reverse().toString();
    }
}