import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DecodeTimelineMessage {
    public static String decodeTimelineMessage(String input) {
        String[] shapes = input.split(";");
        StringBuilder message = new StringBuilder();

        for (String shape : shapes) {
            String[] parts = shape.split(":");
            String shapeType = parts[0];
            String[] coords = parts[1].split(",");

            switch (shapeType) {
                case "triangle":
                    message.append(decodeTriangle(coords)).append(" ");
                    break;
                case "circle":
                    message.append(decodeCircle(coords)).append(" ");
                    break;
                case "rectangle":
                    message.append(decodeRectangle(coords)).append(" ");
                    break;
                case "polygon":
                    message.append(decodePolygon(coords)).append(" ");
                    break;
            }
        }

        return message.toString().trim();
    }

    private static String decodeTriangle(String[] coords) {
        double x1 = Double.parseDouble(coords[0]);
        double y1 = Double.parseDouble(coords[1]);
        double x2 = Double.parseDouble(coords[2]);
        double y2 = Double.parseDouble(coords[3]);
        double x3 = Double.parseDouble(coords[4]);
        double y3 = Double.parseDouble(coords[5]);

        double area = Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)) / 2);
        return decodeWord(area);
    }

    private static String decodeCircle(String[] coords) {
        double radius = Double.parseDouble(coords[2]);
        double circumference = 2 * Math.PI * radius;
        return decodeWord(circumference);
    }

    private static String decodeRectangle(String[] coords) {
        double width = Math.abs(Double.parseDouble(coords[2]) - Double.parseDouble(coords[0]));
        double height = Math.abs(Double.parseDouble(coords[3]) - Double.parseDouble(coords[1]));
        double perimeter = 2 * (width + height);
        return decodeWord(perimeter);
    }

    private static String decodePolygon(String[] coords) {
        int sides = coords.length / 2;
        return decodeWord(sides);
    }

    private static String decodeWord(double value) {
        int rounded = (int) Math.round(value);
        int lastTwoDigits = rounded % 100;
        while (lastTwoDigits > 25) {
            lastTwoDigits -= 26;
        }
        return String.valueOf((char) (lastTwoDigits + 'A'));
    }
}
