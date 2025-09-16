/*
Create a function named organizeCustomerQueue that receives customerNames and accountBalances as its parameters.

Your task is to simulate a bank's customer queue management system. You need to sort the customers based on their account balances (highest to lowest) and then create a formatted string that represents the queue order with additional information.

Follow these steps to complete the challenge:
- Sort the customers based on their account balances in descending order.
- Create a formatted string that includes each customer's position in the queue, their name, and a message based on their account balance.
- Return the formatted string representing the queue.
- Use the following messages based on account balances:
   - For balances over 10000: "VIP customer"
   - For balances between 5000 and 10000 (inclusive): "Regular customer"
   - For balances below 5000: "Please see a financial advisor"

Parameters:
- customerNames (String[]): An array of customer names.
- accountBalances (float[]): An array of corresponding account balances.

The function returns a string where each line represents a customer in the queue, formatted as:
[Position]. [Name] - [Message based on account balance]

Each customer should be on a new line in the returned string.
*/

import java.util.Arrays;
import java.util.Comparator;

class OrganizeCustomerQueue {
    public static String organizeCustomerQueue(String[] customerNames, float[] accountBalances) {
        // Create a class to hold customer information
        class Customer {
            String name;
            float balance;

            Customer(String name, float balance) {
                this.name = name;
                this.balance = balance;
            }
        }

        // Create an array of Customer objects
        Customer[] customers = new Customer[customerNames.length];
        for (int i = 0; i < customerNames.length; i++) {
            customers[i] = new Customer(customerNames[i], accountBalances[i]);
        }

        // Sort customers based on account balances in descending order
        Arrays.sort(customers, Comparator.comparingDouble((Customer c) -> c.balance).reversed());

        // Create the formatted string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < customers.length; i++) {
            String message;
            if (customers[i].balance > 10000) {
                message = "VIP customer";
            } else if (customers[i].balance >= 5000) {
                message = "Regular customer";
            } else {
                message = "Please see a financial advisor";
            }

            result.append(String.format("%d. %s - %s", i + 1, customers[i].name, message));
            if (i < customers.length - 1) {
                result.append("\n");
            }
        }

        return result.toString();
    }
}