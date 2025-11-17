/*
Write a function organizeOfficeSupplies that takes supplies, deskIds, techStatus and returns a string array of supply assignments.

The function organizes office supplies by reassigning them to desks based on technology status, using array reversal for offline segments and tracking assignment moves.

Logic:
- Identify segments of consecutive offline desks (false values in techStatus)
- Reverse the supply order within each offline segment to optimize troubleshooting access
- Skip invalid desk assignments (desk ID ≤ 0) using logical operators
- Use increment/decrement operators to count total reassignment moves
- Generate final assignments in format "SupplyName->DeskID" or "SupplyName->SKIPPED" for invalid desks

Parameters:
- supplies (String[]): Array of office supply names
- deskIds (int[]): Array of desk identification numbers
- techStatus (boolean[]): Array indicating if desk technology is online (true) or offline (false)

Returns: String array of supply assignments. Format: ["Mouse->5", "Keyboard->SKIPPED", "Monitor->3"]
 */

class OrganizeOfficeSupplies {
    public static String[] organizeOfficeSupplies(String[] supplies, int[] deskIds, boolean[] techStatus) {
        String[] result = new String[supplies.length];
        String[] workingSupplies = supplies.clone();

        // Find and reverse offline segments
        int start = -1;
        for (int i = 0; i <= techStatus.length; i++) {
            if (i < techStatus.length && !techStatus[i]) {
                if (start == -1) {
                    start = i;
                }
            } else {
                if (start != -1) {
                    // Reverse the segment from start to i-1
                    reverseSegment(workingSupplies, start, i - 1);
                    start = -1;
                }
            }
        }

        // Generate assignments
        for (int i = 0; i < workingSupplies.length; i++) {
            if (deskIds[i] <= 0) {
                result[i] = workingSupplies[i] + "->SKIPPED";
            } else {
                result[i] = workingSupplies[i] + "->" + deskIds[i];
            }
        }

        return result;
    }

    private static void reverseSegment(String[] arr, int start, int end) {
        while (start < end) {
            String temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}