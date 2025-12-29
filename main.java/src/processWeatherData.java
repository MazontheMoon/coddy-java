/*Write a function processWeatherData that takes locations, temperatures, humidity, salinity and returns a centralized monitoring string.

The function generates unique hash-based location codes and combines all sensor data into a standardized format for the farm's centralized weather monitoring system.

Logic:

Generate a unique 4-character hash code for each location using the sum of ASCII values modulo 10000, formatted as zero-padded string
Create monitoring entries in format: "LOC[hash]:T[temp]H[humidity]S[salinity]"
Concatenate all entries with " | " separator
Parameters:

locations (String[]): Array of grove section names
temperatures (int[]): Temperature readings in Celsius
humidity (int[]): Humidity percentages
salinity (int[]): Soil salinity levels in ppm
Returns: Concatenated monitoring string. Format: LOC0123:T25H65S450 | LOC0456:T27H70S380*/

class ProcessWeatherData {
    public static String processWeatherData(String[] locations, int[] temperatures, int[] humidity, int[] salinity) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < locations.length; i++) {
            // Generate hash code for location
            int asciiSum = 0;
            for (char c : locations[i].toCharArray()) {
                asciiSum += (int) c;
            }
            int hashCode = asciiSum % 10000;
            String hashString = String.format("%04d", hashCode);
            
            // Create monitoring entry
            String entry = "LOC" + hashString + ":T" + temperatures[i] + "H" + humidity[i] + "S" + salinity[i];
            
            if (i > 0) {
                result.append(" | ");
            }
            result.append(entry);
        }
        
        return result.toString();
    }
}
