import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the sign text
        String signText = scanner.nextLine();
        
        // Read the high and low temperatures
        int high = scanner.nextInt();
        int low = scanner.nextInt();
        
        // Toggle the case of all letters in the sign text
        String toggledText = "";
        for (int i = 0; i < signText.length(); i++) {
            char c = signText.charAt(i);
            if (Character.isUpperCase(c)) {
                toggledText += Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                toggledText += Character.toUpperCase(c);
            } else {
                toggledText += c;
            }
        }
        
        // Count the number of spaces in the sign text
        int spaceCount = 0;
        for (int i = 0; i < signText.length(); i++) {
            if (signText.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        
        // Calculate the temperature range
        int range = high - low;
        
        // Print the results
        System.out.println(toggledText);
        System.out.println(spaceCount);
        System.out.println(range);
    }
}