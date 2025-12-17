*/
Write a function generateComplianceReport that takes equipmentLogs, staffSchedules, and productBatches and returns a consolidated compliance report string.

The function processes bakery data for health inspection, detecting duplicates using hash codes, filtering records with break/continue statements, and resolving conflicts by reversing priority order.

Logic:

Generate hash codes for each record to detect duplicates across all three arrays
Use break/continue to skip expired items (containing "EXPIRED") and stop processing when "CRITICAL" violation found
For duplicate hash codes, reverse the order of conflicting records to prioritize most recent
Return format: "EQUIPMENT:[count]|STAFF:[count]|PRODUCTS:[count]|STATUS:[PASS/CRITICAL]"

Parameters:

equipmentLogs (String[]): Equipment maintenance records
staffSchedules (String[]): Staff certification schedules
productBatches (String[]): Product batch tracking records
Returns: Compliance report string. Format: EQUIPMENT:3|STAFF:2|PRODUCTS:4|STATUS:PASS
/*

import java.util.*;

class GenerateComplianceReport {
    public static String generateComplianceReport(String[] equipmentLogs, String[] staffSchedules, String[] productBatches) {
        Set<Integer> seenHashes = new HashSet<>();
        List<String> validEquipment = new ArrayList<>();
        List<String> validStaff = new ArrayList<>();
        List<String> validProducts = new ArrayList<>();
        boolean criticalFound = false;
        
        // Process equipment logs
        for (String equipment : equipmentLogs) {
            if (equipment.contains("EXPIRED")) {
                continue;
            }
            if (equipment.contains("CRITICAL")) {
                criticalFound = true;
                break;
            }
            
            int hash = equipment.hashCode();
            if (seenHashes.contains(hash)) {
                // Reverse order for duplicates - add at beginning
                validEquipment.add(0, equipment);
            } else {
                validEquipment.add(equipment);
                seenHashes.add(hash);
            }
        }
        
        // Process staff schedules (only if no critical found)
        if (!criticalFound) {
            for (String staff : staffSchedules) {
                if (staff.contains("EXPIRED")) {
                    continue;
                }
                if (staff.contains("CRITICAL")) {
                    criticalFound = true;
                    break;
                }
                
                int hash = staff.hashCode();
                if (seenHashes.contains(hash)) {
                    // Reverse order for duplicates - add at beginning
                    validStaff.add(0, staff);
                } else {
                    validStaff.add(staff);
                    seenHashes.add(hash);
                }
            }
        }
        
        // Process product batches (only if no critical found)
        if (!criticalFound) {
            for (String product : productBatches) {
                if (product.contains("EXPIRED")) {
                    continue;
                }
                if (product.contains("CRITICAL")) {
                    criticalFound = true;
                    break;
                }
                
                int hash = product.hashCode();
                if (seenHashes.contains(hash)) {
                    // Reverse order for duplicates - add at beginning
                    validProducts.add(0, product);
                } else {
                    validProducts.add(product);
                    seenHashes.add(hash);
                }
            }
        }
        
        String status = criticalFound ? "CRITICAL" : "PASS";
        
        return String.format("EQUIPMENT:%d|STAFF:%d|PRODUCTS:%d|STATUS:%s", 
                           validEquipment.size(), 
                           validStaff.size(), 
                           validProducts.size(), 
                           status);
    }
}