/*
Create a function named shepherdCall that receives shepherdName (String) and sheepCount (int) as its parameters.

The function simulates a shepherd's call to his sheep on a hillside. It should return a formatted string that includes the shepherd's name (both forward and reversed) and a series of "baa" sounds based on the number of sheep.

The function should perform the following operations:
- Reverse the shepherdName.
- Create a string of "baa" sounds, repeated sheepCount times.
- Format the output string as follows: "[shepherdName] calls: [reversedShepherdName]! [baa x sheepCount]"

Parameters:
- shepherdName (String): The name of the shepherd. It will contain only basic ASCII letters (both uppercase and lowercase) and will have a length of at least 1 and at most 50 characters.
- sheepCount (int): The number of sheep in the flock. It will be a positive integer not exceeding 20.
*/

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ShepherdCall {
    public static String shepherdCall(String shepherdName, int sheepCount) {
        String reversedName = new StringBuilder(shepherdName).reverse().toString();
        String baaSounds = "baa ".repeat(sheepCount).trim();
        return String.format("%s calls: %s! %s", shepherdName, reversedName, baaSounds);
    }
}