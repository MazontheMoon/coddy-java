import java.util.ArrayList;

class GoldPannerGame {
    public static String[] goldPannerGame(String message, int encryptionKey) {
        String encoded = encode(message, encryptionKey);
        String decoded = decode(encoded, encryptionKey);
        return new String[]{encoded, decoded};
    }

    private static String encode(String message, int key) {
        StringBuilder reversed = new StringBuilder(message).reverse();
        StringBuilder encoded = new StringBuilder();
        for (char c : reversed.toString().toCharArray()) {
            encoded.append((char) (((c + key - 32) % 95) + 32));
        }
        return encoded.toString();
    }

    private static String decode(String encoded, int key) {
        StringBuilder decoded = new StringBuilder();
        for (char c : encoded.toCharArray()) {
            decoded.append((char) (((c - key - 32 + 95) % 95) + 32));
        }
        return decoded.reverse().toString();
    }
}