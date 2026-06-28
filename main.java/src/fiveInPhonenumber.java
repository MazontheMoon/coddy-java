import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the full name
        String fullName = scanner.nextLine();
        
        // Read the phone number
        String phoneNumber = scanner.nextLine();
        
        // Count words in the name (split by spaces and count non-empty parts)
        String[] nameParts = fullName.trim().split("\\s+");
        int wordCount = nameParts.length;
        
        // Count how many times digit 5 appears in the phone number
        int fiveCount = 0;
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (phoneNumber.charAt(i) == '5') {
                fiveCount++;
            }
        }
        
        // Print the results
        System.out.println(wordCount + " " + fiveCount);
    }
}
