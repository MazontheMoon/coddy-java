import java.util.*;

class MatchTechSupport {
    public static String[] matchTechSupport(String[] volunteers, String[] requests, String[] timeSlots) {
        List<String> validPairings = new ArrayList<>();
        
        // Parse volunteers
        Map<String, String> volunteerSkills = new HashMap<>();
        for (String volunteer : volunteers) {
            String[] parts = volunteer.split(":");
            volunteerSkills.put(parts[0], parts[1]);
        }
        
        // Parse requests
        Map<String, String[]> requestData = new HashMap<>();
        for (String request : requests) {
            String[] parts = request.split(":");
            requestData.put(parts[0], new String[]{parts[1], parts[2]});
        }
        
        // Parse time slots
        Map<String, String> timeAvailability = new HashMap<>();
        for (String timeSlot : timeSlots) {
            String[] parts = timeSlot.split(":");
            timeAvailability.put(parts[0], parts[1]);
        }
        
        // Check all volunteer-request combinations
        for (String volunteerName : volunteerSkills.keySet()) {
            for (String requestId : requestData.keySet()) {
                String volunteerSkill = volunteerSkills.get(volunteerName);
                String[] requestInfo = requestData.get(requestId);
                String requiredSkills = requestInfo[0];
                String priority = requestInfo[1];
                
                // Concatenate volunteer skill with request priority
                String volunteerSkillWithPriority = volunteerSkill + priority;
                
                // Check if volunteer skills contain required skills
                if (volunteerSkillWithPriority.contains(requiredSkills)) {
                    // Check time availability overlap
                    String volunteerTime = timeAvailability.get(volunteerName);
                    String requestTime = timeAvailability.get(requestId);
                    
                    if (volunteerTime != null && requestTime != null && 
                        volunteerTime.length() >= 5 && requestTime.length() >= 5) {
                        
                        String volunteerTimeSlot = volunteerTime.substring(2, 5);
                        String requestTimeSlot = requestTime.substring(2, 5);
                        
                        // Count overlapping characters
                        int overlapCount = countOverlap(volunteerTimeSlot, requestTimeSlot);
                        
                        if (overlapCount >= 2) {
                            validPairings.add(volunteerName + "-" + requestId);
                        }
                    }
                }
            }
        }
        
        return validPairings.toArray(new String[0]);
    }
    
    private static int countOverlap(String str1, String str2) {
        int count = 0;
        Map<Character, Integer> charCount1 = new HashMap<>();
        Map<Character, Integer> charCount2 = new HashMap<>();
        
        // Count characters in first string
        for (char c : str1.toCharArray()) {
            charCount1.put(c, charCount1.getOrDefault(c, 0) + 1);
        }
        
        // Count characters in second string
        for (char c : str2.toCharArray()) {
            charCount2.put(c, charCount2.getOrDefault(c, 0) + 1);
        }
        
        // Count overlapping characters
        for (char c : charCount1.keySet()) {
            if (charCount2.containsKey(c)) {
                count += Math.min(charCount1.get(c), charCount2.get(c));
            }
        }
        
        return count;
    }
}