/*
Create a function named duckPondVisit that receives initialDucks, isSunny, and arrivingDucks as its parameters.

The function simulates a visit to a tranquil duck pond lined with hopbush shrubs. It tracks the number of ducks in the pond over time, considering weather conditions and new arrivals.

Follow these rules to simulate the duck pond visit:
- If it's sunny, only 1 duck leaves each hour; if it's not sunny, 2 ducks leave (the number of ducks can't go below 0).
- After calculating departures, add the number of new ducks arriving for that hour.
- Create a status update string for each hour in the format: "Hour X: Y ducks in the pond".
- If the number of ducks reaches 15 or more, add " - Pond is getting crowded!" to that hour's status.
- The visit duration is determined by the length of the arrivingDucks array.

Parameters:
- initialDucks (int): The number of ducks initially in the pond.
- isSunny (boolean): Indicates whether it's a sunny day (true) or not (false).
- arrivingDucks (int[]): An array representing the number of ducks arriving each hour.
The function returns a String array containing status updates for each hour of the visit.
 */

import java.util.ArrayList;

class DuckPondVisit {
    public static String[] duckPondVisit(int initialDucks, boolean isSunny, int[] arrivingDucks) {
        ArrayList<String> statusUpdates = new ArrayList<>();
        int currentDucks = initialDucks;
        int leavingDucks = isSunny ? 1 : 2;

        for (int hour = 0; hour < arrivingDucks.length; hour++) {
            currentDucks = Math.max(0, currentDucks - leavingDucks);
            currentDucks += arrivingDucks[hour];

            String status = "Hour " + (hour + 1) + ": " + currentDucks + " ducks in the pond";
            if (currentDucks >= 15) {
                status += " - Pond is getting crowded!";
            }
            statusUpdates.add(status);
        }

        return statusUpdates.toArray(new String[0]);
    }
}
