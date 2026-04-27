import java.text.DecimalFormat;

class FormatShrimpReport {
    public static String formatShrimpReport(String speciesName, int count, float length, String color, String habitat) {
        DecimalFormat df = new DecimalFormat("#.0");
        String formattedLength = df.format(length);
        
        return String.format("Shrimp Species: %s\nCount: %d\nAverage Length: %s cm\nColor: %s\nHabitat: %s",
                             speciesName, count, formattedLength, color, habitat);
    }
}
