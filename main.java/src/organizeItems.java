import java.util.*;

class OrganizeItems {
    public static int[][] organizeItems(String[][] rooms) {
        int[][] result = new int[rooms.length][3];
        
        for (int i = 0; i < rooms.length; i++) {
            String[] room = rooms[i];
            int keep = 0, donate = 0, discard = 0;
            List<String> processedItems = new ArrayList<>();
            
            for (String item : room) {
                if (isPalindrome(item)) {
                    keep++;
                } else if (isAnagramOfPrevious(item, processedItems)) {
                    donate++;
                } else {
                    discard++;
                }
                processedItems.add(item);
            }
            
            result[i][0] = keep;
            result[i][1] = donate;
            result[i][2] = discard;
        }
        
        return result;
    }
    
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    private static boolean isAnagramOfPrevious(String item, List<String> processedItems) {
        for (String processed : processedItems) {
            if (areAnagrams(item, processed)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return Arrays.equals(chars1, chars2);
    }
}
