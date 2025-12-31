/*
Create a function named illuminateStreet that receives boolean[] lamps as its parameter.

In this challenge, you'll simulate the journey of Lumos, a whimsical lamplighter who illuminates the streets at dusk. Lumos starts at the beginning of the street and moves along, lighting up lamps as he goes.

Implement the following behavior for Lumos:

Lumos starts at the first lamp (index 0) and moves rightwards.
As Lumos passes each lamp, he turns it on if it's off.
Lumos uses his magical lantern to illuminate a slice of 3 lamps at once.
Every 5th step, Lumos looks back (decrements his position) to double-check the previous lamp.
If Lumos reaches the end of the street, he turns around and starts moving leftwards.
Lumos stops when all lamps are lit or when he has taken 100 steps, whichever comes first.
Use the following Java concepts in your implementation:

Advanced increment and decrement operators to control Lumos's movement.
Array slicing to simulate Lumos's magical lantern that lights up multiple lamps at once.
Break and continue statements to control the flow of Lumos's journey.
Parameters:

lamps (boolean[]): An array representing the initial state of the street lamps. false means the lamp is off, and true means it is on.
The function should return a String[] where each element represents the state of the street after each step Lumos takes. Each string in the array should consist of '0's and '1's, where '0' represents an unlit lamp and '1' represents a lit lamp.

Here's an example of how to represent the street state as a string:


boolean[] currentState = {true, false, true, false, true};
String stateString = new String(new char[currentState.length]).replace("\0", "0");
for (int i = 0; i < currentState.length; i++) {
    if (currentState[i]) {
        stateString = stateString.substring(0, i) + "1" + stateString.substring(i + 1);
    }
}
// stateString will be "10101"

Remember, Lumos stops when all lamps are lit or after 100 steps. Make sure to handle both these conditions in your implementation.
*/

import java.util.ArrayList;
import java.util.Arrays;

class IlluminateStreet {
    public static String[] illuminateStreet(boolean[] lamps) {
        ArrayList<String> states = new ArrayList<>();
        int position = 0;
        int steps = 0;
        boolean movingRight = true;

        while (steps < 100) {
            // Light up current lamp and its neighbors
            for (int i = Math.max(0, position - 1); i <= Math.min(lamps.length - 1, position + 1); i++) {
                lamps[i] = true;
            }

            // Add current state to states
            states.add(getStateString(lamps));

            // Check if all lamps are lit
            if (allLampsLit(lamps)) {
                break;
            }

            // Move Lumos
            if (movingRight) {
                if (position == lamps.length - 1) {
                    movingRight = false;
                    position--;
                } else if ((steps + 1) % 5 == 0 && position > 0) {
                    position--;
                } else {
                    position++;
                }
            } else {
                if (position == 0) {
                    movingRight = true;
                    position++;
                } else if ((steps + 1) % 5 == 0 && position < lamps.length - 1) {
                    position++;
                } else {
                    position--;
                }
            }

            steps++;
        }

        return states.toArray(new String[0]);
    }

    private static String getStateString(boolean[] lamps) {
        char[] stateChars = new char[lamps.length];
        for (int i = 0; i < lamps.length; i++) {
            stateChars[i] = lamps[i] ? '1' : '0';
        }
        return new String(stateChars);
    }

    private static boolean allLampsLit(boolean[] lamps) {
        for (boolean lamp : lamps) {
            if (!lamp) {
                return false;
            }
        }
        return true;
    }
}