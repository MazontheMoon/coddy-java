/*
Create a function named createSetlist that receives firstSet and secondSet as its parameters.

This function merges two setlists and removes any duplicate songs.

To achieve this:
- Concatenate firstSet and secondSet to create a single array.
- Remove any duplicate songs from the combined array.
- Return the resulting setlist as a string array.
The order of the songs in the final setlist should follow the order in which they appear in the input setlists, with the songs from firstSet coming before the songs from secondSet.

Parameters:
- firstSet (String[]): The setlist for the first part of the performance.
- secondSet (String[]): The setlist for the second part of the performance.
The function returns a String[] representing the combined setlist with no duplicate songs.
 */

import java.util.ArrayList;
import java.util.LinkedHashSet;

class CreateSetlist {
    public static String[] createSetlist(String[] firstSet, String[] secondSet) {
        ArrayList<String> combinedList = new ArrayList<>();

        // Add songs from firstSet to combinedList
        for (String song : firstSet) {
            combinedList.add(song);
        }

        // Add songs from secondSet to combinedList
        for (String song : secondSet) {
            combinedList.add(song);
        }

        // Remove duplicate songs while preserving the order
        LinkedHashSet<String> uniqueSongs = new LinkedHashSet<>(combinedList);

        // Convert the LinkedHashSet back to an array
        String[] finalSetlist = uniqueSongs.toArray(new String[0]);

        return finalSetlist;
    }
}
