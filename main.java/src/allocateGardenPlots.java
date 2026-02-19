import java.util.*;

class AllocateGardenPlots {
    public static int[] allocateGardenPlots(String[] plantNames, int[] growthHeights) {
        List<Integer> plotSizes = new ArrayList<>();
        
        for (int i = 0; i < plantNames.length && i < growthHeights.length; i++) {
            String plantName = plantNames[i];
            int growthHeight = growthHeights[i];
            
            // Skip entries where plant name is empty or null
            if (plantName == null || plantName.isEmpty()) {
                continue;
            }
            
            // Stop processing if growth height is negative
            if (growthHeight < 0) {
                break;
            }
            
            // Calculate base plot size as growth height × 2
            int plotSize = growthHeight * 2;
            
            // Add 10 bonus if plant name is a palindrome (case-insensitive)
            if (isPalindrome(plantName)) {
                plotSize += 10;
            }
            
            // Add 20 bonus if growth height is a perfect number
            if (isPerfectNumber(growthHeight)) {
                plotSize += 20;
            }
            
            plotSizes.add(plotSize);
        }
        
        return plotSizes.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private static boolean isPalindrome(String str) {
        String normalized = str.toLowerCase();
        int left = 0;
        int right = normalized.length() - 1;
        
        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    private static boolean isPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        
        int sum = 1; // 1 is always a divisor
        
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) { // Avoid adding the same divisor twice for perfect squares
                    sum += num / i;
                }
            }
        }
        
        return sum == num;
    }
}
