import java.util.*;

class OrganizeWinterActivities {
    public static String organizeWinterActivities(String[] familyMembers, String[] activities) {
        // Group family members by their preferred activities
        Map<String, List<String>> activityGroups = new LinkedHashMap<>();
        
        for (int i = 0; i < familyMembers.length; i++) {
            String activity = activities[i];
            String member = familyMembers[i];
            
            activityGroups.computeIfAbsent(activity, k -> new ArrayList<>()).add(member);
        }
        
        // Sort activities by popularity (most participants first)
        List<Map.Entry<String, List<String>>> sortedActivities = new ArrayList<>(activityGroups.entrySet());
        sortedActivities.sort((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()));
        
        // Build the formatted string
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < sortedActivities.size(); i++) {
            Map.Entry<String, List<String>> entry = sortedActivities.get(i);
            String activity = entry.getKey();
            List<String> members = entry.getValue();
            
            // Reverse the order of member names
            Collections.reverse(members);
            
            // Format the line
            String membersList = String.join(", ", members);
            int guestCount = members.size();
            String guestWord = guestCount == 1 ? "guest" : "guests";
            
            result.append(activity).append(": [").append(membersList).append("] (")
                  .append(guestCount).append(" ").append(guestWord).append(")");
            
            // Add newline if not the last entry
            if (i < sortedActivities.size() - 1) {
                result.append("\n");
            }
        }
        
        return result.toString();
    }
}
