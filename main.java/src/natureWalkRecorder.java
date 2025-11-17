/*
Create a function named natureWalkRecorder that receives observations and pattern as its parameters.

During a peaceful walk in the park, you're tasked with recording the natural elements you observe. However, the beauty of nature has inspired you to record these observations in a unique pattern. Your function should process the observations and return them in the specified pattern.

Implement this function using a combination of advanced data structures (specifically, a linked list) and control flow concepts. You'll need to manipulate the array, implement a linked list, and use control flow statements to achieve the desired pattern.

Parameters:
- observations (int[]): An array of integers representing the elements observed during the walk. Each integer corresponds to a natural element (1 = tree, 2 = flower, 3 = bird, 4 = squirrel, 5 = butterfly).
- pattern (int): An integer representing the recording pattern (1 = normal order, 2 = reverse order, 3 = alternating order).
The function returns a String array representing the recorded observations based on the given pattern.

Follow these steps to implement the function:
- Create a linked list to temporarily store the observations.
- Traverse the input array and add each element to the linked list.
Based on the pattern parameter, process the linked list:
	- If pattern is 1, keep the order as is.
	- If pattern is 2, reverse the entire linked list.
	- If pattern is 3, reverse every other element in the linked list.
Convert the processed linked list back to an array, translating the integer codes to descriptive strings.
Use appropriate control flow statements (like break and continue) to handle the different patterns efficiently.
 */

import java.util.LinkedList;

class NatureWalkRecorder {
    public static String[] natureWalkRecorder(int[] observations, int pattern) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Step 1 & 2: Create a linked list and add observations
        for (int observation : observations) {
            linkedList.add(observation);
        }

        // Step 3: Process the linked list based on the pattern
        switch (pattern) {
            case 1:
                // Normal order, do nothing
                break;
            case 2:
                // Reverse order
                LinkedList<Integer> reversedList = new LinkedList<>();
                while (!linkedList.isEmpty()) {
                    reversedList.addFirst(linkedList.removeFirst());
                }
                linkedList = reversedList;
                break;
            case 3:
                // Alternating order
                for (int i = 1; i < linkedList.size(); i += 2) {
                    int temp = linkedList.get(i);
                    linkedList.set(i, linkedList.get(i - 1));
                    linkedList.set(i - 1, temp);
                }
                break;
        }

        // Step 4: Convert the processed linked list back to an array with descriptive strings
        String[] result = new String[linkedList.size()];
        for (int i = 0; i < result.length; i++) {
            int code = linkedList.get(i);
            switch (code) {
                case 1:
                    result[i] = "tree";
                    break;
                case 2:
                    result[i] = "flower";
                    break;
                case 3:
                    result[i] = "bird";
                    break;
                case 4:
                    result[i] = "squirrel";
                    break;
                case 5:
                    result[i] = "butterfly";
                    break;
                default:
                    result[i] = "unknown";
            }
        }

        return result;
    }
}