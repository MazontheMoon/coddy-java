import java.util.HashMap;
import java.util.Map;

class AnalyzePlantCells {
    public static String analyzePlantCells(String input) {
        Map<String, String> characteristics = parseInput(input);
        String tissueType = determineTissueType(characteristics);
        String function = determineFunction(tissueType);
        String age = determineAge(characteristics);
        String properties = determineProperties(characteristics);

        return String.format("tissue_type:%s;function:%s;age:%s;properties:%s", tissueType, function, age, properties);
    }

    private static Map<String, String> parseInput(String input) {
        Map<String, String> characteristics = new HashMap<>();
        String[] pairs = input.split(";");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            characteristics.put(keyValue[0], keyValue[1]);
        }
        return characteristics;
    }

    private static String determineTissueType(Map<String, String> characteristics) {
        String cellShape = characteristics.getOrDefault("cell_shape", "");
        String wallThickness = characteristics.getOrDefault("wall_thickness", "");
        String ligninContent = characteristics.getOrDefault("lignin_content", "");

        if (wallThickness.equals("thick") && ligninContent.equals("high") && cellShape.equals("elongated")) {
            return "sclerenchyma";
        } else if (wallThickness.equals("thin") && characteristics.getOrDefault("vacuole_size", "").equals("large")) {
            return "parenchyma";
        } else if (wallThickness.equals("unevenly thickened") && cellShape.equals("elongated")) {
            return "collenchyma";
        } else {
            return "unknown";
        }
    }

    private static String determineFunction(String tissueType) {
        switch (tissueType) {
            case "sclerenchyma":
                return "structural support and protection";
            case "parenchyma":
                return "storage and metabolism";
            case "collenchyma":
                return "flexible support in growing tissues";
            default:
                return "unknown";
        }
    }

    private static String determineAge(Map<String, String> characteristics) {
        String wallThickness = characteristics.getOrDefault("wall_thickness", "");
        String ligninContent = characteristics.getOrDefault("lignin_content", "");

        if (wallThickness.equals("thick") || ligninContent.equals("high")) {
            return "mature";
        } else if (wallThickness.equals("thin") || ligninContent.equals("low")) {
            return "young";
        } else {
            return "intermediate";
        }
    }

    private static String determineProperties(Map<String, String> characteristics) {
        StringBuilder properties = new StringBuilder();

        if (characteristics.getOrDefault("cell_arrangement", "").equals("ordered")) {
            properties.append("organized structure, ");
        }
        if (characteristics.getOrDefault("nucleus_position", "").equals("peripheral")) {
            properties.append("peripheral nucleus, ");
        }
        if (characteristics.getOrDefault("vacuole_size", "").equals("small")) {
            properties.append("small vacuoles, ");
        }

        return properties.length() > 0 ? properties.substring(0, properties.length() - 2) : "none observed";
    }
}