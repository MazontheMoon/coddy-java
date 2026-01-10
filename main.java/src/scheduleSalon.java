import java.util.*;

class ScheduleSalon {
    public static String[][] scheduleSalon(int[] clientIds, String[] treatments, int[] durations, int[][] availabilityGrid) {
        int rows = availabilityGrid.length;
        int cols = availabilityGrid[0].length;
        
        // Initialize result grid with empty strings
        String[][] schedule = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                schedule[i][j] = "";
            }
        }
        
        // Create a copy of availability grid to track occupied slots
        int[][] occupied = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                occupied[i][j] = availabilityGrid[i][j];
            }
        }
        
        // Process each client
        for (int clientIndex = 0; clientIndex < clientIds.length; clientIndex++) {
            int clientId = clientIds[clientIndex];
            String treatment = treatments[clientIndex];
            int duration = durations[clientIndex];
            
            boolean scheduled = false;
            
            // Try to find a suitable slot
            for (int row = 0; row < rows && !scheduled; row++) {
                for (int col = 0; col <= cols - duration && !scheduled; col++) {
                    // Check if we can place the appointment starting at (row, col)
                    boolean canPlace = true;
                    for (int k = 0; k < duration; k++) {
                        if (occupied[row][col + k] == 0) {
                            canPlace = false;
                            break;
                        }
                    }
                    
                    if (canPlace) {
                        // Place the appointment
                        String appointmentStr = clientId + ":" + treatment;
                        for (int k = 0; k < duration; k++) {
                            schedule[row][col + k] = appointmentStr;
                            occupied[row][col + k] = 0; // Mark as occupied
                        }
                        scheduled = true;
                    }
                }
            }
        }
        
        return schedule;
    }
}

