import java.util.*;

class OrganizeMessages {
    public static String[] organizeMessages(String[][] messages, String[] reminders) {
        List<String> allMessages = new ArrayList<>();
        
        // Flatten the 2D messages array
        for (String[] messageGroup : messages) {
            for (String message : messageGroup) {
                allMessages.add(message);
            }
        }
        
        // Add reminders to the list
        for (String reminder : reminders) {
            allMessages.add(reminder);
        }
        
        // Reverse the entire list
        Collections.reverse(allMessages);
        
        // Convert to array and return
        return allMessages.toArray(new String[0]);
    }
}
