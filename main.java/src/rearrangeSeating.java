/*
Create a function named rearrangeSeating that receives seatingArrangement and seatingChanges as parameters.

This function updates the seating arrangement at Lea's garden party based on guest arrivals and departures.

Steps:
- Iterate through each element of the seatingChanges array.
- Update the corresponding table's seating count in the seatingArrangement array by adding the change value.
- Return the updated seatingArrangement array.

Parameters:
- seatingArrangement (int[]): Initial seating arrangement, where each element indicates the number of guests seated at a particular table.
- seatingChanges (int[]): Changes in the number of guests at each table, where positive values indicate arrivals and negative values indicate departures.

The function returns an int[] representing the updated seating arrangement after applying the changes.
*/

class RearrangeSeating {
    public static int[] rearrangeSeating(int[] seatingArrangement, int[] seatingChanges) {
        for (int i = 0; i < seatingChanges.length; i++) {
            seatingArrangement[i] += seatingChanges[i];
        }
        return seatingArrangement;
    }
}