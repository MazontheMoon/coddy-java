class OrganizePetCare {
    public static String[] organizePetCare(String[] petNames, boolean[] isAnxious) {
        String[] careInstructions = new String[petNames.length];
        
        // Create care instructions for each pet
        for (int i = 0; i < petNames.length; i++) {
            String careType = isAnxious[i] ? "Needs extra care" : "Standard care";
            careInstructions[i] = petNames[i] + ": " + careType;
        }
        
        // Reverse the order
        String[] reversed = new String[careInstructions.length];
        for (int i = 0; i < careInstructions.length; i++) {
            reversed[i] = careInstructions[careInstructions.length - 1 - i];
        }
        
        return reversed;
    }
}
