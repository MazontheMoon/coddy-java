/*
Write a function manageReservations that takes tableStatuses, reservations, diceInventory and returns a formatted status report.

The function manages table assignments and dice inventory for a board game café, processing reservations in order and updating availability.

Logic:
- For each reservation, find the first available table that matches the required capacity
- If a table is found, assign it and reduce dice inventory by the number of players
- If no table is available or insufficient dice, add to waiting list
- Generate a status report with assigned tables and waiting customers

Parameters:
- tableStatuses (int[][]): 2D array where each row represents [tableId, capacity, isAvailable] (1=available, 0=occupied)
- reservations (String[]): Array of reservation strings in format "CustomerName-Players"
- diceInventory (int): Current number of dice sets available

Returns: Status report string. Format: Assigned: [CustomerName-TableId], [CustomerName-TableId] Waiting: [CustomerName], [CustomerName] Dice Remaining: [number]
*/

import java.util.*;

class ManageReservations {
    public static String manageReservations(int[][] tableStatuses, String[] reservations, int diceInventory) {
        List<String> assigned = new ArrayList<>();
        List<String> waiting = new ArrayList<>();
        int remainingDice = diceInventory;

        // Create a copy of table statuses to track availability
        int[][] tables = new int[tableStatuses.length][3];
        for (int i = 0; i < tableStatuses.length; i++) {
            tables[i][0] = tableStatuses[i][0]; // tableId
            tables[i][1] = tableStatuses[i][1]; // capacity
            tables[i][2] = tableStatuses[i][2]; // isAvailable
        }

        for (String reservation : reservations) {
            String[] parts = reservation.split("-");
            String customerName = parts[0];
            int players = Integer.parseInt(parts[1]);

            boolean tableFound = false;

            // Check if we have enough dice
            if (remainingDice >= players) {
                // Find first available table with sufficient capacity
                for (int i = 0; i < tables.length; i++) {
                    if (tables[i][2] == 1 && tables[i][1] >= players) {
                        // Assign table
                        assigned.add(customerName + "-" + tables[i][0]);
                        tables[i][2] = 0; // Mark as occupied
                        remainingDice -= players;
                        tableFound = true;
                        break;
                    }
                }
            }

            if (!tableFound) {
                waiting.add(customerName);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("Assigned: ");
        if (assigned.isEmpty()) {
            result.append("");
        } else {
            result.append(String.join(", ", assigned));
        }

        result.append("\nWaiting: ");
        if (waiting.isEmpty()) {
            result.append("");
        } else {
            result.append(String.join(", ", waiting));
        }

        result.append("\nDice Remaining: ").append(remainingDice);

        return result.toString();
    }
}


