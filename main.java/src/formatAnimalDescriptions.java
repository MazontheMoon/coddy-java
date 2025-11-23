/*
Create a function named formatAnimalDescriptions that receives descriptions as its parameter.

This function aims to format and rearrange animal descriptions from a zoo visit.

The descriptions parameter is an array where each string represents a scrambled description of an animal. Each description is a semi-colon separated string containing the zoo section number, animal count, and a brief description, but the sections might be in a scrambled order.

To solve this challenge, follow these steps:
- Reverse the order of the descriptions array to start the descriptions from the last section.
- For each description string:
	- Split the string by semi-colon to separate the section number, animal count, and description.
	- Extract the section number and convert it to an integer.
	- Extract the animal count, increment it by 1 if the section number is even, or decrement it by 1 if the section number is odd.
- Construct the formatted description string in the format: "In Section X, there are Y animals: [description]", where X is the section number and Y is the updated animal count.
Return the formatted descriptions as a new array.

Parameters:
- descriptions (String[]): An array where each string represents a scrambled description of an animal.
The function returns a String[] where each string is a neatly formatted description of the animal. Each description should start with the formatted zoo section, followed by the formatted animal count, and end with the description.
*/

import java.util.Arrays;

class FormatAnimalDescriptions {
    public static String[] formatAnimalDescriptions(String[] descriptions) {
        // Reverse the order of the descriptions array
        String[] reversedDescriptions = new String[descriptions.length];
        for (int i = 0; i < descriptions.length; i++) {
            reversedDescriptions[i] = descriptions[descriptions.length - 1 - i];
        }

        // Format each description
        String[] formattedDescriptions = new String[reversedDescriptions.length];
        for (int i = 0; i < reversedDescriptions.length; i++) {
            String[] parts = reversedDescriptions[i].split(";");
            int sectionNumber = Integer.parseInt(parts[0].split(" ")[1]);
            int animalCount = Integer.parseInt(parts[1].split(" ")[0]);
            String description = parts[2];

            // Increment or decrement animal count based on section number
            if (sectionNumber % 2 == 0) {
                animalCount++;
            } else {
                animalCount--;
            }

            // Construct the formatted description string
            String formattedDescription = "In Section " + sectionNumber + ", there are " + animalCount + " animals: " + description;
            formattedDescriptions[i] = formattedDescription;
        }

        return formattedDescriptions;
    }
}