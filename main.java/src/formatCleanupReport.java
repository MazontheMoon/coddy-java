class FormatCleanupReport {
    public static String formatCleanupReport(int[][] zones) {
        StringBuilder report = new StringBuilder();
        
        // Process zones in reverse order
        for (int i = zones.length - 1; i >= 0; i--) {
            int totalDebris = 0;
            
            // Calculate total debris for current zone
            for (int debris : zones[i]) {
                totalDebris += debris;
            }
            
            // Add zone info to report
            int zoneNumber = zones.length - i;
            report.append("Zone ").append(zoneNumber).append(": ").append(totalDebris).append(" items");
            
            // Add newline if not the last zone
            if (i > 0) {
                report.append("\n");
            }
        }
        
        return report.toString();
    }
}
