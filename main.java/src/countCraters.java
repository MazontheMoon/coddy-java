/*
Create a function named countCraters that receives observations as its parameter.

This function counts the number of crater observations in the given lunar surface data until a rock is encountered.

Iterate through the observations array:
- If the observation is "crater", increment the count.
- If the observation is "rock", break the loop.
- If the observation is "plain", continue to the next observation.
- Return the total count of craters observed.

Parameters:
- observations (String[]): An array of strings representing the observations of the lunar surface. Each element can be "crater", "plain", or "rock".
Returns an integer representing the count of craters observed until a rock is encountered, or the total count if no rock is found.
*/

class CountCraters {
    public static int countCraters(String[] observations) {
        int craterCount = 0;
        for (String observation : observations) {
            if (observation.equals("crater")) {
                craterCount++;
            } else if (observation.equals("rock")) {
                break;
            }
        }
        return craterCount;
    }
}