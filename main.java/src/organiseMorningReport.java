import java.util.*;

class OrganizeMorningReport {
    public static String[] organizeMorningReport(float[] dewLevels, String[] sectionNames) {
        // Create pairs of dew level and section name
        List<DewSection> sections = new ArrayList<>();
        for (int i = 0; i < dewLevels.length; i++) {
            sections.add(new DewSection(dewLevels[i], sectionNames[i]));
        }
        
        // Sort by dew level in ascending order
        sections.sort((a, b) -> Float.compare(a.dewLevel, b.dewLevel));
        
        // Create formatted reports
        String[] reports = new String[sections.size()];
        for (int i = 0; i < sections.size(); i++) {
            DewSection section = sections.get(i);
            reports[i] = "Morning dew in " + section.sectionName + ": " + section.dewLevel + "mm";
        }
        
        return reports;
    }
    
    private static class DewSection {
        float dewLevel;
        String sectionName;
        
        DewSection(float dewLevel, String sectionName) {
            this.dewLevel = dewLevel;
            this.sectionName = sectionName;
        }
    }
}