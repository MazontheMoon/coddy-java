class PathToHiddenWaterfall {
    public static String pathToHiddenWaterfall(String[] terrainDescriptions, int steps) {
        // Reverse the entries in terrainDescriptions
        for (int i = 0; i < terrainDescriptions.length / 2; i++) {
            String temp = terrainDescriptions[i];
            terrainDescriptions[i] = terrainDescriptions[terrainDescriptions.length - 1 - i];
            terrainDescriptions[terrainDescriptions.length - 1 - i] = temp;
        }

        // Replace every third description containing "rocky" with "stream"
        for (int i = 2; i < terrainDescriptions.length; i += 3) {
            if (terrainDescriptions[i].contains("rocky")) {
                terrainDescriptions[i] = "stream";
            }
        }

        // Append " - path found" to descriptions with odd length and containing "tree"
        for (int i = 0; i < terrainDescriptions.length; i++) {
            if (terrainDescriptions[i].length() % 2 != 0 && terrainDescriptions[i].contains("tree")) {
                terrainDescriptions[i] += " - path found";
            }
        }

        // Calculate the index of the hidden waterfall based on the steps
        int index = steps % terrainDescriptions.length;

        // Return the description of the terrain at the calculated index
        return terrainDescriptions[index];
    }
}
