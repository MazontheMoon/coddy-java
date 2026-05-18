import java.util.ArrayList;

class ApplyTopcoat {
    public static String applyTopcoat(int roomLength, int roomWidth, float coatAvailable) {
        int roomArea = roomLength * roomWidth;
        float coatNeeded = roomArea / 100.0f;
        ArrayList<String> progressUpdates = new ArrayList<>();
        
        StringBuilder result = new StringBuilder();
        result.append(String.format("Room area: %d sq ft\n", roomArea));
        result.append(String.format("Topcoat needed: %.2f gallons\n", coatNeeded));
        
        int coatedArea = 0;
        int rowsCoated = 0;
        
        while (coatAvailable > 0 && coatedArea < roomArea) {
            if (coatAvailable >= roomWidth / 100.0f) {
                coatedArea += roomWidth;
                coatAvailable -= roomWidth / 100.0f;
                rowsCoated++;
                progressUpdates.add(String.format("Row %d coated. %.2f gallons remaining.", rowsCoated, coatAvailable));
            } else {
                break;
            }
        }
        
        for (String update : progressUpdates) {
            result.append(update).append("\n");
        }
        
        if (coatedArea >= roomArea) {
            result.append(String.format("Floor coating complete. Used %.2f gallons of topcoat.", coatNeeded));
        } else {
            int uncoatedArea = roomArea - coatedArea;
            result.append(String.format("Ran out of topcoat. %d sq ft left uncoated.", uncoatedArea));
        }
        
        return result.toString();
    }
}
