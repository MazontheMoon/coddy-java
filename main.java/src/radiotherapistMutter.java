/*
Create a function named radiotherapistMutter that receives patientNumber as its parameter.

The function simulates a radiotherapist's muttering while preparing for patients. It generates a string that represents the radiotherapist's thoughts, including the patient number, a substring of a predefined phrase, and a countdown.

Use the following predefined phrase: "Another day, another dose of radiation therapy."

The function should generate an output string in the format: "Patient {number}: {substring of phrase}... {countdown}"

Parameters:
- patientNumber (int): The current patient number (between 1 and 100, inclusive).

The function returns a string representing the radiotherapist's muttering.

Rules:
- Use the patient number to determine how much of the phrase to include in the output.
- Include a countdown from 5 to 1, representing the radiotherapist's mental preparation.
- Use basic substring operations to handle parts of the string.
- Utilize increment or decrement operators to manage the countdown.
*/

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class RadiotherapistMutter {
    public static String radiotherapistMutter(int patientNumber) {
        String phrase = "Another day, another dose of radiation therapy.";
        int substringLength = Math.min(patientNumber, phrase.length());
        String substring = phrase.substring(0, substringLength);

        String countdown = IntStream.rangeClosed(1, 5)
                .mapToObj(Integer::toString)
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.joining(" "));

        return String.format("Patient %d: %s... %s", patientNumber, substring, countdown);
    }
}