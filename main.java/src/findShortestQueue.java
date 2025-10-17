/*
Create a function named findShortestQueue that receives queueLengths as its parameter.

You are at a bustling marketplace, and you need to find the shortest queue to join. Your task is to create a function that helps customers find the shortest queue based on the number of people waiting in each queue.

The function should search through the array of queue lengths, find the shortest queue (the one with the least number of people), and return a message indicating which queue the customer should join. If there are multiple shortest queues, choose the one that appears first in the array.

Parameters:
- queueLengths (int[]): An array of integers where each element represents the number of people in a queue. The index of each element (starting from 0) represents the queue number minus 1.
The function returns a string message in the format "Queue X with Y person(s)", where X is the queue number (1-indexed) and Y is the number of people in that queue.

Here's an example of how to solve this problem:
- Initialize variables to keep track of the shortest queue length and its index.
- Iterate through the queueLengths array.
- Update the shortest queue length and index when a shorter queue is found.
- After the iteration, form the output string using the found shortest queue index and length.
Remember to handle the case where there might be an empty queue (0 people) as it would be the shortest.
 */

import java.util.Arrays;

class FindShortestQueue {
    public static String findShortestQueue(int[] queueLengths) {
        if (queueLengths == null || queueLengths.length == 0) {
            return "No queues available";
        }

        int shortestQueueIndex = 0;
        int shortestQueueLength = queueLengths[0];

        for (int i = 1; i < queueLengths.length; i++) {
            if (queueLengths[i] < shortestQueueLength) {
                shortestQueueIndex = i;
                shortestQueueLength = queueLengths[i];
            }
        }

        int queueNumber = shortestQueueIndex + 1;
        String personOrPersons = shortestQueueLength == 1 ? "person" : "persons";

        return String.format("Queue %d with %d %s", queueNumber, shortestQueueLength, personOrPersons);
    }
}
