/*
Create a function named geometricOdyssey that receives coordinates, shapeTypes, startBase, and targetBase as its parameters.

The function simulates a sportsman's journey through a geometric landscape, combining advanced geometry concepts with number base conversions. The sportsman will navigate through the landscape, encountering different geometric shapes and performing specific tasks for each.

Parameters:

coordinates (int[][]): A 2D array of integers representing coordinates of various geometric shapes in the landscape. Each sub-array contains two integers [x, y].
shapeTypes (String[]): An array of strings representing the types of geometric shapes at each coordinate. Possible values are "triangle", "circle", "polygon", and "solid".
startBase (int): An integer representing the starting base for number conversions (2 ≤ startBase ≤ 36).
targetBase (int): An integer representing the target base for number conversions (2 ≤ targetBase ≤ 36).
The function should perform the following tasks:

For triangles: Calculate the area and perimeter, convert the results to the target base.
For circles: Calculate the circumference and area, convert the results to the target base.
For polygons: Determine the number of sides, calculate the interior angles, convert the results to the target base.
For 3D solids (represented by their 2D projections): Calculate the surface area and volume, convert the results to the target base.
Perform geometric transformations on certain shapes, such as rotations, reflections, or scaling, and calculate new coordinates in the target base.
Solve vector-based challenges, including calculations of dot products, cross products, and vector magnitudes, all converted to the target base.
Use advanced geometric formulas and proofs to solve complex problems, such as finding the intersection of multiple shapes or determining if a point lies inside a given shape.

The function returns a string representing the sportsman's journey log, including the challenges faced and overcome. Each line of the log should be in the format: "Shape X: [calculations and results in target base]".

Note: Use Math.PI for π in your calculations. Round all final results to 2 decimal places before converting to the target base. When converting to the target base, use uppercase letters for bases above 10.

Constraints:

2 ≤ coordinates.length ≤ 10
-1000 ≤ coordinates[i][j] ≤ 1000
2 ≤ startBase, targetBase ≤ 36
*/

import java.util.Arrays;
import java.lang.Math;

class GeometricOdyssey {
    public static String geometricOdyssey(int[][] coordinates, String[] shapeTypes, int startBase, int targetBase) {
        StringBuilder journey = new StringBuilder();

        for (int i = 0; i < coordinates.length; i++) {
            int[] coord = coordinates[i];
            String shapeType = shapeTypes[i];
            journey.append("Shape ").append(i + 1).append(": ");

            switch (shapeType) {
                case "triangle":
                    handleTriangle(journey, coord, coordinates[(i + 1) % coordinates.length], coordinates[(i + 2) % coordinates.length], targetBase);
                    break;
                case "circle":
                    handleCircle(journey, coord, targetBase);
                    break;
                case "polygon":
                    handlePolygon(journey, coord, targetBase);
                    break;
                case "solid":
                    handleSolid(journey, coord, targetBase);
                    break;
            }

            journey.append("\n");
        }

        return journey.toString();
    }

    private static void handleTriangle(StringBuilder journey, int[] a, int[] b, int[] c, int targetBase) {
        double area = Math.abs(a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1])) / 2.0;
        double perimeter = distance(a, b) + distance(b, c) + distance(c, a);
        journey.append("Area: ").append(convertToBase(area, targetBase))
               .append(", Perimeter: ").append(convertToBase(perimeter, targetBase));
    }

    private static void handleCircle(StringBuilder journey, int[] center, int targetBase) {
        double radius = Math.sqrt(center[0] * center[0] + center[1] * center[1]);
        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;
        journey.append("Circumference: ").append(convertToBase(circumference, targetBase))
               .append(", Area: ").append(convertToBase(area, targetBase));
    }

    private static void handlePolygon(StringBuilder journey, int[] coord, int targetBase) {
        int sides = Math.abs(coord[0] + coord[1]);
        double interiorAngle = (sides - 2) * 180.0 / sides;
        journey.append("Sides: ").append(convertToBase(sides, targetBase))
               .append(", Interior Angle: ").append(convertToBase(interiorAngle, targetBase));
    }

    private static void handleSolid(StringBuilder journey, int[] dimensions, int targetBase) {
        double surfaceArea = 6 * dimensions[0] * dimensions[1];
        double volume = Math.pow(dimensions[0] * dimensions[1], 1.5);
        journey.append("Surface Area: ").append(convertToBase(surfaceArea, targetBase))
               .append(", Volume: ").append(convertToBase(volume, targetBase));
    }

    private static double distance(int[] a, int[] b) {
        return Math.sqrt(Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
    }

    private static String convertToBase(double value, int base) {
        value = Math.round(value * 100) / 100.0;
        int intPart = (int) value;
        double fracPart = value - intPart;

        String intString = Integer.toString(intPart, base).toUpperCase();
        StringBuilder fracString = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            fracPart *= base;
            int digit = (int) fracPart;
            fracString.append(Integer.toString(digit, base).toUpperCase());
            fracPart -= digit;
        }

        return intString + "." + fracString;
    }
}
