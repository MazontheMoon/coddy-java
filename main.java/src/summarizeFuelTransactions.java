/*
Write a function summarizeFuelTransactions that takes transactions and returns a formatted fuel sales summary.

The function processes gas station transaction records, groups them by fuel type, and calculates totals for each type.

Logic:

Parse each transaction string to extract fuel type, quantity, and unit price
Group transactions by fuel type and calculate total liters and revenue
Format results as a multi-line summary report
Parameters:

transactions (String[]): Array of transaction records in format "pumpId:fuelType:quantity:unitPrice"
Returns: Formatted summary string. Format: FuelType: X.X liters, $X.XX revenue FuelType: X.X liters, $X.XX revenue
*/

import java.util.*;

class SummarizeFuelTransactions {
    public static String summarizeFuelTransactions(String[] transactions) {
        Map<String, Double> totalLiters = new HashMap<>();
        Map<String, Double> totalRevenue = new HashMap<>();

        for (String transaction : transactions) {
            String[] parts = transaction.split(":");
            String fuelType = parts[1];
            double quantity = Double.parseDouble(parts[2]);
            double unitPrice = Double.parseDouble(parts[3]);
            double revenue = quantity * unitPrice;

            totalLiters.put(fuelType, totalLiters.getOrDefault(fuelType, 0.0) + quantity);
            totalRevenue.put(fuelType, totalRevenue.getOrDefault(fuelType, 0.0) + revenue);
        }

        List<String> fuelTypes = new ArrayList<>(totalLiters.keySet());
        Collections.sort(fuelTypes);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fuelTypes.size(); i++) {
            String fuelType = fuelTypes.get(i);
            double liters = totalLiters.get(fuelType);
            double revenue = totalRevenue.get(fuelType);

            result.append(String.format("%s: %.1f liters, $%.2f revenue", fuelType, liters, revenue));
            if (i < fuelTypes.size() - 1) {
                result.append("\n");
            }
        }

        return result.toString();
    }
}