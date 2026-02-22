class FormatFossilExhibit {
    public static String formatFossilExhibit(String name, int age, String discoveredBy, boolean isComplete) {
        String completeness = isComplete ? "Complete specimen:" : "Partial specimen:";
        String ageDescription = age > 100 ? "Ancient " + age : String.valueOf(age);
        
        return String.format("%s %s, %s million years old, discovered by %s", 
                             completeness, name, ageDescription, discoveredBy);
    }
}
