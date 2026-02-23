import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the artifact ages
        String agesLine = scanner.nextLine();
        String[] agesStr = agesLine.split(" ");
        
        // Read the calibration factor
        double calibrationFactor = Double.parseDouble(scanner.nextLine());
        
        // Calculate and print corrected ages
        StringBuilder correctedAges = new StringBuilder();
        for (int i = 0; i < agesStr.length; i++) {
            int age = Integer.parseInt(agesStr[i]);
            int correctedAge = (int) Math.round(age * calibrationFactor);
            correctedAges.append(correctedAge);
            if (i < agesStr.length - 1) {
                correctedAges.append(" ");
            }
        }
        System.out.println(correctedAges.toString());
        
        // Read the old catalog code
        String oldCode = scanner.nextLine();
        
        // Read the new catalog code
        String newCode = scanner.nextLine();
        
        // Read the description text
        String description = scanner.nextLine();
        
        // Replace the first occurrence of old code with new code
        String updatedDescription = description.replaceFirst(oldCode, newCode);
        
        // Print the updated description
        System.out.println(updatedDescription);
        
        scanner.close();
    }
}
