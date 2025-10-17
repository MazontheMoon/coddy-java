/*
Create a function named countSheep that receives sheepNames and fullNames as its parameters.

This function aims to count the number of sheep that Farmer John successfully identified based on the names he heard and the full names of all his sheep.

Farmer John calls out the names of his sheep as they pass through the gate in the evening, but sometimes the wind carries away part of the name. You are given two arrays:
- sheepNames: An array of strings representing the names of the sheep as Farmer John heard them. Some names might be incomplete due to the wind.
- fullNames: An array of strings containing the full and correct names of all of Farmer John's sheep.
Your task is to count the number of sheep whose heard name is an exact match to one of the full names in fullNames. Partial matches do not count - the heard name must match a full name exactly.

Parameters:
- sheepNames (String[]): An array of strings representing the names of the sheep as Farmer John heard them. Each string consists of lowercase English letters only.
- fullNames (String[]): An array of strings containing the full and correct names of all of Farmer John's sheep. Each string consists of lowercase English letters only.
The function returns an integer representing the number of sheep that Farmer John successfully identified (i.e., the number of heard names that exactly match a full name).
 */

class CountSheep {
    public static int countSheep(String[] sheepNames, String[] fullNames) {
        int count = 0;
        for (String sheepName : sheepNames) {
            for (String fullName : fullNames) {
                if (sheepName.equals(fullName)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}