import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the three inputs
        String name = scanner.nextLine();
        String roomStr = scanner.nextLine();
        String idStr = scanner.nextLine();
        
        // Clean the name by removing all punctuation
        String cleanedName = name.replaceAll("[^a-zA-Z0-9 ]", "");
        
        // Check if room number is a valid power of 10
        int room = Integer.parseInt(roomStr);
        String roomValidity = "Invalid";
        if (room == 1 || room == 10 || room == 100 || room == 1000 || room == 10000) {
            roomValidity = "Valid";
        }
        
        // Format ID with leading zeros to make it exactly 6 digits
        int id = Integer.parseInt(idStr);
        String formattedId;
        if (id > 999999) {
            // If ID is already more than 6 digits, keep it as is
            formattedId = idStr;
        } else {
            formattedId = String.format("%06d", id);
        }
        
        // Print results
        System.out.println(cleanedName);
        System.out.println(roomValidity);
        System.out.println(formattedId);
    }
}