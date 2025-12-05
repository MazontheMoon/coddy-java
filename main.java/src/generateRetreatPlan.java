/*
Write a function generateRetreatPlan that takes guestLogs and maxSupplies and returns a formatted schedule array.

The function processes guest arrival logs for your Methodist church group's mountain cabin retreat, converting arrival times to a special binary format and managing supply limitations.

Logic:
 - Parse each log entry in "Name:HH:MM" format to extract name, hour, and minute
- Convert the hour (0-23) to its binary string representation
- Format each entry as "Name arrives at binaryHour:MM"
- Use continue to skip processing when supply count exceeds maxSupplies
- Use break to stop after processing 24 entries total
- Track supplies used (increment by 1 for each processed guest)

Parameters:
- guestLogs (String[]): Array of guest arrival logs in "Name:HH:MM" format
- maxSupplies (int): Maximum number of supply packages available

Returns: String array of formatted arrival schedules. Format: ["John arrives at 1001:30", "Mary arrives at 1010:15"]
*/

import java.util.ArrayList;

class GenerateRetreatPlan {
    public static String[] generateRetreatPlan(String[] guestLogs, int maxSupplies) {
        ArrayList<String> schedule = new ArrayList<>();
        int suppliesUsed = 0;
        int processedEntries = 0;
        
        for (String log : guestLogs) {
            if (processedEntries >= 24) {
                break;
            }
            
            if (suppliesUsed >= maxSupplies) {
                continue;
            }
            
            String[] parts = log.split(":");
            String name = parts[0];
            int hour = Integer.parseInt(parts[1]);
            String minute = parts[2];
            
            String binaryHour = Integer.toBinaryString(hour);
            String formattedEntry = name + " arrives at " + binaryHour + ":" + minute;
            
            schedule.add(formattedEntry);
            suppliesUsed++;
            processedEntries++;
        }
        
        return schedule.toArray(new String[0]);
    }
}