import java.util.ArrayList;
import java.util.Arrays;

class PlanClumsyEscape {
    public static String planClumsyEscape(String exhibits, String magicWord) {
        String[] exhibitArray = exhibits.split(",");
        ArrayList<String> escapeRoute = new ArrayList<>();

        for (String exhibit : exhibitArray) {
            if (exhibit.contains("o")) {
                continue;
            }
            if (exhibit.equals(magicWord)) {
                break;
            }
            escapeRoute.add(exhibit);
        }

        if (escapeRoute.isEmpty()) {
            return "Oops! Back to the drawing board!";
        }

        return String.join(" -> ", escapeRoute);
    }
}
