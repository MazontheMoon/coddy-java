class OrganizeBookSale {
    public static String[] organizeBookSale(String[] genres, int maxBooksPerTable) {
        String[] result = new String[genres.length];
        int mysteryCount = 0;
        int generalTableNumber = 1;
        int currentGeneralCount = 0;
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            
            // Check if genre contains "Detective" or "Mystery"
            if (genre.contains("Detective") || genre.contains("Mystery")) {
                // Check if Mystery table has reached capacity
                if (mysteryCount >= maxBooksPerTable) {
                    continue; // Skip processing this book
                }
                result[i] = "Mystery";
                mysteryCount++;
            } else {
                // Check if current general table has reached capacity
                if (currentGeneralCount >= maxBooksPerTable) {
                    generalTableNumber++;
                    currentGeneralCount = 0;
                }
                result[i] = "General-" + generalTableNumber;
                currentGeneralCount++;
            }
        }
        
        return result;
    }
}
