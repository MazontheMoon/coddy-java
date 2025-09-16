/*
Create a function named determineWaterBottleType that receives temperature and prefersColdWater as its parameters.

This function determines the type of water bottle to distribute during a heatwave based on the temperature and the person's preference for cold water.

Rules:
- If temperature is 30°C or higher, return "cold water bottle" regardless of preference.
- If temperature is below 30°C and prefersColdWater, return "cold water bottle".
- Otherwise, return "room temperature water bottle".

Parameters:
- temperature (int): Current temperature in degrees Celsius.
- prefersColdWater (boolean): Indicates if the person prefers cold water.

Returns a String: "cold water bottle" or "room temperature water bottle".

*/

class DetermineWaterBottleType {
    public static String determineWaterBottleType(int temperature, boolean prefersColdWater) {
        if (temperature >= 30 || (temperature < 30 && prefersColdWater)) {
            return "cold water bottle";
        } else {
            return "room temperature water bottle";
        }
    }
}

