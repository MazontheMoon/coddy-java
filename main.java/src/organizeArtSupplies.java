class OrganizeArtSupplies {
    public static String[][] organizeArtSupplies(String[][] supplies) {
        // Create a new 2D array with the same dimensions
        String[][] organized = new String[supplies.length][];
        
        // Iterate through each shelf (row)
        for (int i = 0; i < supplies.length; i++) {
            // Initialize the row with the same length
            organized[i] = new String[supplies[i].length];
            
            // Reverse the supplies on this shelf using nested loops
            for (int j = 0; j < supplies[i].length; j++) {
                organized[i][j] = supplies[i][supplies[i].length - 1 - j];
            }
        }
        
        return organized;
    }
}
