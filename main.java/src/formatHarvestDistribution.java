/*
Write a function formatHarvestDistribution that takes plants, families and returns a formatted string showing the harvest distribution.

The function pairs each plant with a family and creates distribution messages for the community garden harvest.

Parameters:
- plants (String[]): Array of plant names from the garden
- families (String[]): Array of family names receiving produce
Returns: String with distribution messages, each on a new line. Format: The [family name] family gets [plant name] The [family name] family gets [plant name]
*/

class FormatHarvestDistribution {
    public static String formatHarvestDistribution(String[] plants, String[] families) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < plants.length && i < families.length; i++) {
            result.append("The ").append(families[i]).append(" family gets ").append(plants[i]);
            if (i < plants.length - 1 && i < families.length - 1) {
                result.append("\n");
            }
        }

        return result.toString();
    }
}