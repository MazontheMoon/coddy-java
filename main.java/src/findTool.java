/*
Create a function named findTool that receives toolDescription and inventory as its parameters.

This function helps customers find the right tool based on their description from the available inventory in the hardware store.

The function should check if any tool in the inventory array contains the toolDescription string. If a match is found, return the full name of the tool. If no tool matches the description, return "Tool not found".

The comparison should be case-insensitive.

Parameters:
- toolDescription (String): The description of the tool the customer is looking for.
- inventory (String[]): An array representing all the tools currently available in the store.

The function returns a String, either the full name of the matching tool or "Tool not found" if no match is found.
 */

class FindTool {
    public static String findTool(String toolDescription, String[] inventory) {
        for (String tool : inventory) {
            if (tool.toLowerCase().contains(toolDescription.toLowerCase())) {
                return tool;
            }
        }
        return "Tool not found";
    }
}