/*
Create a function named organizeWorkshopInventory that receives toolNames and quantities as its parameters.

Your task is to organize a cabinetmaker's workshop inventory using a custom data structure that combines aspects of a linked list and a hash table for efficient storage and retrieval.

Implement the following operations:
- Create a custom data structure where each node contains the tool name, quantity, and a pointer to the next node.
- Implement a hash function to distribute the tools across the data structure.
- Insert all tools and their quantities into the custom data structure.
- Implement a searching algorithm to find tools based on their names.
- Create a method to update the quantity of a specific tool.
Implement a method to remove tools with zero quantity from the inventory.

After organizing the inventory, return a sorted array of strings representing the current inventory status.

Parameters:
- toolNames (String[]): An array of tool names in the workshop.
- quantities (int[]): An array of corresponding quantities for each tool.

The function returns a String[] where each string is formatted as "ToolName: Quantity", sorted alphabetically by tool name.
*/
import java.util.*;

class OrganizeWorkshopInventory {
    private static class Node {
        String toolName;
        int quantity;
        Node next;

        Node(String toolName, int quantity) {
            this.toolName = toolName;
            this.quantity = quantity;
            this.next = null;
        }
    }

    private static final int TABLE_SIZE = 10;
    private static Node[] table = new Node[TABLE_SIZE];

    private static int hash(String toolName) {
        return Math.abs(toolName.hashCode() % TABLE_SIZE);
    }

    private static void insert(String toolName, int quantity) {
        int index = hash(toolName);
        Node newNode = new Node(toolName, quantity);
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            while (current.next != null) {
                if (current.toolName.equals(toolName)) {
                    current.quantity += quantity;
                    return;
                }
                current = current.next;
            }
            if (current.toolName.equals(toolName)) {
                current.quantity += quantity;
            } else {
                current.next = newNode;
            }
        }
    }

    private static Node find(String toolName) {
        int index = hash(toolName);
        Node current = table[index];
        while (current != null) {
            if (current.toolName.equals(toolName)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private static void updateQuantity(String toolName, int newQuantity) {
        Node tool = find(toolName);
        if (tool != null) {
            tool.quantity = newQuantity;
        }
    }

    private static void removeZeroQuantity() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            Node dummy = new Node("", 0);
            dummy.next = table[i];
            Node current = dummy;
            while (current.next != null) {
                if (current.next.quantity == 0) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
            table[i] = dummy.next;
        }
    }

    public static String[] organizeWorkshopInventory(String[] toolNames, int[] quantities) {
        for (int i = 0; i < toolNames.length; i++) {
            insert(toolNames[i], quantities[i]);
        }

        removeZeroQuantity();

        List<String> inventory = new ArrayList<>();
        for (Node node : table) {
            while (node != null) {
                inventory.add(node.toolName + ": " + node.quantity);
                node = node.next;
            }
        }

        Collections.sort(inventory);
        return inventory.toArray(new String[0]);
    }
}

