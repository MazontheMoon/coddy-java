class CatalogMedicalBooks {
    public static String catalogMedicalBooks(String[] catalogEntries) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < catalogEntries.length; i++) {
            String[] parts = catalogEntries[i].split("\\|");
            String title = parts[0];
            String author = parts[1];
            String status = parts[2];
            
            // Determine category
            String category = determineCategory(title);
            
            // Determine availability
            String availability = status.equals("IN") ? "Available" : "Checked Out";
            
            // Format the entry
            String formattedEntry = category + " - " + title + " by " + author + ": " + availability;
            
            result.append(formattedEntry);
            if (i < catalogEntries.length - 1) {
                result.append("\n");
            }
        }
        
        return result.toString();
    }
    
    private static String determineCategory(String title) {
        String lowerTitle = title.toLowerCase();
        
        if (lowerTitle.contains("surgical") || lowerTitle.contains("surgery")) {
            return "Surgery";
        } else if (lowerTitle.contains("research") || lowerTitle.contains("methodology")) {
            return "Research";
        } else {
            return "General";
        }
    }
}
