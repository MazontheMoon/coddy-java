/*
Create a function named catalogSculptures that receives heightMeasurements and widthMeasurements as its parameters.

This function combines height and width measurements of bronze sculptures into a single catalog.

To create the catalog:
- Iterate through the heightMeasurements and widthMeasurements arrays simultaneously.
- For each index, combine the corresponding height and width measurements into a string formatted as "Height: [height]cm, Width: [width]cm".
- Add each combined measurement string to a new array, maintaining the original order.
- Return the array of combined measurements as the sculpture catalog.

Parameters:
- heightMeasurements (int[]): An array of integer height measurements in centimeters.
- widthMeasurements (int[]): An array of integer width measurements in centimeters, guaranteed to be the same length as heightMeasurements.

The function returns a String[] representing the sculpture catalog, where each element is a combined measurement of height and width for a sculpture section.
*/

class CatalogSculptures {
    public static String[] catalogSculptures(int[] heightMeasurements, int[] widthMeasurements) {
        String[] catalog = new String[heightMeasurements.length];

        for (int i = 0; i < heightMeasurements.length; i++) {
            int height = heightMeasurements[i];
            int width = widthMeasurements[i];
            String measurement = "Height: " + height + "cm, Width: " + width + "cm";
            catalog[i] = measurement;
        }

        return catalog;
    }
}