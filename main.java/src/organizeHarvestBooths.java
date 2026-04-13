import java.util.ArrayList;
import java.util.List;

class OrganizeHarvestBooths {
    public static int[] organizeHarvestBooths(int[][] boothSections, int troublesomeVolunteerId) {
        List<Integer> validItems = new ArrayList<>();
        
        for (int[] section : boothSections) {
            // Check if section contains troublesome volunteer ID
            boolean containsTroublesomeVolunteer = false;
            for (int item : section) {
                if (item == troublesomeVolunteerId) {
                    containsTroublesomeVolunteer = true;
                    break;
                }
            }
            
            // Skip this section if it contains the troublesome volunteer
            if (containsTroublesomeVolunteer) {
                continue;
            }
            
            // Process remaining sections - only include perfect numbers
            for (int item : section) {
                if (isPerfectNumber(item)) {
                    validItems.add(item);
                }
            }
        }
        
        // Convert list to array
        return validItems.stream().mapToInt(i -> i).toArray();
    }
    
    private static boolean isPerfectNumber(int number) {
        String numStr = String.valueOf(number);
        int digitCount = numStr.length();
        int digitSum = 0;
        
        for (char digit : numStr.toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }
        
        return digitSum == digitCount;
    }
}
