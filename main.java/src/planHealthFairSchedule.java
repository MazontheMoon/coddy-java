class PlanHealthFairSchedule {
    public static String[][] planHealthFairSchedule(String[] boothNames, String[] volunteerCodes, String[] visitorGroups, String targetWord) {
        int numBooths = boothNames.length;
        String[][] schedule = new String[numBooths][4];
        
        for (int i = 0; i < numBooths; i++) {
            // Calculate start time (booth index * 30 minutes)
            int startTime = i * 30;
            schedule[i][0] = "StartTime: " + startTime;
            
            // Check if visitor group is palindrome for priority
            String group = visitorGroups[i % visitorGroups.length];
            boolean isPriority = isPalindrome(group);
            schedule[i][1] = "Priority: " + isPriority;
            
            // Check if volunteer code is anagram of target word
            String volunteerCode = volunteerCodes[i % volunteerCodes.length];
            boolean isValidVolunteer = isAnagram(volunteerCode, targetWord);
            schedule[i][2] = "Volunteer: " + (isValidVolunteer ? "valid" : "invalid");
            
            // Build schedule entry
            String boothName = boothNames[i];
            schedule[i][3] = "Schedule: " + boothName + "-" + group;
        }
        
        return schedule;
    }
    
    private static boolean isPalindrome(String str) {
        // Remove spaces and convert to lowercase
        String cleaned = str.replaceAll(" ", "").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;
        
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    private static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Convert to lowercase for comparison
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // Count characters in both strings
        int[] count = new int[26];
        
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
            count[str2.charAt(i) - 'a']--;
        }
        
        // Check if all counts are zero
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
