/*
Create a function named courtDebateIntensity that receives numberOfArguments and initialIntensity as its parameters.

The function simulates a courtroom debate over ethical boundaries in literature, where each argument affects the debate's intensity.

Use nested loops to represent different phases of the debate and increment/decrement operators to adjust the intensity level. The outer loop iterates through each argument, while the inner loop simulates the intensity building up. After each argument, there's a brief "cooling down" period where the intensity decreases slightly.

Parameters:
- numberOfArguments (int): The number of arguments presented in the debate.
- initialIntensity (int): The starting intensity level of the debate.
The function returns an integer representing the final intensity level after all arguments have been presented.

Ensure your solution uses nested loops and basic increment/decrement operators, and fits within 10 to 19 lines of code.
*/

class CourtDebateIntensity {
    public static int courtDebateIntensity(int numberOfArguments, int initialIntensity) {
        int intensity = initialIntensity;
        for (int i = 0; i < numberOfArguments; i++) {
            for (int j = 0; j < 3; j++) {
                intensity++;
            }
            intensity += 2;
            for (int k = 0; k < 2; k++) {
                intensity--;
            }
        }
        return intensity;
    }
}