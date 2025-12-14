/*
Create a function named simulateFibonacciInNature that receives n and events as its parameters.

This function simulates the Fibonacci sequence in nature, considering the impact of different events on the growth pattern.

The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones, usually starting with 0 and 1. The function should generate the Fibonacci sequence up to the nth number, with growth affected by the events in the events array:

"rain": Doubles the next number in the sequence.
"drought": Skips the next number in the sequence.
"normal": Follows the standard Fibonacci pattern.
Parameters:

n (int): The number of elements to generate in the Fibonacci sequence.
events (String[]): An array of strings representing the events for each day of the simulation. The length of the events array will always be equal to n.
The function returns an integer array representing the Fibonacci sequence based on the given n and events.
*/

class SimulateFibonacciInNature {
    public static int[] simulateFibonacciInNature(int n, String[] events) {
        int[] fib = new int[n];
        fib[0] = 0;
        if (n > 1) {
            fib[1] = 1;
        }
        int i = 2;
        int j = 0;
        while (i < n) {
            String event = events[j];
            if (event.equals("normal")) {
                fib[i] = fib[i - 1] + fib[i - 2];
                i++;
            } else if (event.equals("rain")) {
                fib[i] = fib[i - 1] * 2;
                i++;
            } else if (event.equals("drought")) {
                i++;
            }
            j++;
        }
        return fib;
    }
}
