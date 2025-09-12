/*
Create a function named conductExperiment that receives initialResults, mixedUpSamples, and lastMinuteAddition as its parameters.

In a disorganized laboratory, a group of clumsy scientists are conducting a humorous experiment. Your task is to help them make sense of their results.

The function should perform the following steps:
- If mixedUpSamples is true, reverse the order of the initialResults array.
- Convert lastMinuteAddition to an integer and append it to the end of the results array.
- Determine if the experiment was successful based on these criteria:

The experiment is successful if the sum of all results is even AND the last result is greater than the first result.
Otherwise, the experiment is considered a failure.

Parameters:
- initialResults (int[]): An array of integers representing the initial experiment results.
- mixedUpSamples (boolean): A flag indicating whether the scientists accidentally mixed up their samples.
- lastMinuteAddition (String): A string representing a last-minute addition to the experiment (always a valid integer).

The function should return a string in the format: "Experiment [successful/failed]: [final results array]".

For example, if the experiment was successful and the final results array is [3, 1, 4, 5], the function should return: "Experiment successful: [3, 1, 4, 5]"
*/
import java.util.Arrays;

public class conductExperiment {
    public static String conductExperiment(int[] initialResults, boolean mixedUpSamples, String lastMinuteAddition) {
        if (mixedUpSamples) {
            reverseArray(initialResults);
        }

        int[] finalResults = Arrays.copyOf(initialResults, initialResults.length + 1);
        finalResults[finalResults.length - 1] = Integer.parseInt(lastMinuteAddition);

        int sum = 0;
        for (int result : finalResults) {
            sum += result;
        }

        boolean isSuccessful = (sum % 2 == 0) && (finalResults[finalResults.length - 1] > finalResults[0]);

        String status = isSuccessful ? "successful" : "failed";
        return String.format("Experiment %s: %s", status, Arrays.toString(finalResults));
    }

    private static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
