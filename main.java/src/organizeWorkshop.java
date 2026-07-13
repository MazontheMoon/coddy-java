class OrganizeWorkshop {
    public static String organizeWorkshop(String[] components, float benchWidth, float benchDepth) {
        int resistors = 0;
        int capacitors = 0;
        int other = 0;
        
        for (String component : components) {
            if (component == null || component.isEmpty()) {
                continue;
            }
            
            String lowerComponent = component.toLowerCase();
            
            // Check for prohibited materials and break if found
            if (lowerComponent.contains("lead") || lowerComponent.contains("mercury")) {
                break;
            }
            
            // Categorize components
            if (lowerComponent.contains("resistor") || lowerComponent.contains("ohm")) {
                resistors++;
            } else if (lowerComponent.contains("capacitor") || lowerComponent.contains("ceramic") || lowerComponent.contains("electrolytic")) {
                capacitors++;
            } else {
                other++;
            }
        }
        
        // Calculate optimal angle
        float optimalAngle = (benchWidth / benchDepth) * 15;
        String formattedAngle = String.format("%.1f", optimalAngle);
        
        return String.format("Resistors: %d, Capacitors: %d, Other: %d, Optimal Angle: %s degrees", 
                           resistors, capacitors, other, formattedAngle);
    }
}
