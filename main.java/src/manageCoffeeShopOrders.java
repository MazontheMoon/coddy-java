/*
Create a function named manageCoffeeShopOrders that receives String[] orders and String[] operations as its parameters.

You are working at a cozy local coffee shop, and you need to manage the incoming orders efficiently. The function should process the orders array based on the given operations.

Each order in the orders array is a string in the format "CustomerName:CoffeeType:Size". The function should process the following operations:

"SERVE": Remove the first order from the array (the oldest order).
"ADD_LAST CustomerName:CoffeeType:Size": Add a new order to the end of the array.
"MODIFY index CoffeeType": Change the coffee type of the order at the given index.
"PRIORITIZE index": Move the order at the given index to the front of the array.
"REMOVE CustomerName": Remove all orders for the specified customer.
"SIZE_UP index": Increase the size of the coffee at the given index (Small -> Medium -> Large).
Parameters:

orders (String[]): An array of customer orders, where each order is a string in the format "CustomerName:CoffeeType:Size".
operations (String[]): An array of operations to perform on the orders.
The function returns a String[] representing the modified array of orders after applying all operations.

Note: Assume that all inputs are valid and properly formatted. The indices in the operations are 0-based and will always be within the bounds of the array.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ManageCoffeeShopOrders {
    public static String[] manageCoffeeShopOrders(String[] orders, String[] operations) {
        List<String> orderList = new ArrayList<>(Arrays.asList(orders));

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];

            switch (command) {
                case "SERVE":
                    if (!orderList.isEmpty()) {
                        orderList.remove(0);
                    }
                    break;
                case "ADD_LAST":
                    orderList.add(parts[1]);
                    break;
                case "MODIFY":
                    int index = Integer.parseInt(parts[1]);
                    String[] orderParts = orderList.get(index).split(":");
                    orderParts[1] = parts[2];
                    orderList.set(index, String.join(":", orderParts));
                    break;
                case "PRIORITIZE":
                    index = Integer.parseInt(parts[1]);
                    String prioritizedOrder = orderList.remove(index);
                    orderList.add(0, prioritizedOrder);
                    break;
                case "REMOVE":
                    orderList.removeIf(order -> order.startsWith(parts[1] + ":"));
                    break;
                case "SIZE_UP":
                    index = Integer.parseInt(parts[1]);
                    orderParts = orderList.get(index).split(":");
                    String size = orderParts[2];
                    if (size.equals("Small")) {
                        orderParts[2] = "Medium";
                    } else if (size.equals("Medium")) {
                        orderParts[2] = "Large";
                    }
                    orderList.set(index, String.join(":", orderParts));
                    break;
            }
        }

        return orderList.toArray(new String[0]);
    }
}