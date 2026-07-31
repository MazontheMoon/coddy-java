import java.util.regex.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

class ProcessHairLossConferenceData {
    public static String processHairLossConferenceData(String transcript) {
        // Extract percentages and convert to hexadecimal
        List<String> hexPercentages = new ArrayList<>();
        Pattern percentPattern = Pattern.compile("(\\d+(?:\\.\\d+)?)%");
        Matcher percentMatcher = percentPattern.matcher(transcript);
        while (percentMatcher.find()) {
            double percentage = Double.parseDouble(percentMatcher.group(1));
            hexPercentages.add(Integer.toHexString((int) Math.round(percentage)));
        }

        // Extract treatment durations and convert to binary days
        List<String> binaryDays = new ArrayList<>();
        Pattern durationPattern = Pattern.compile("(\\d+)\\s*(month|year)s?");
        Matcher durationMatcher = durationPattern.matcher(transcript);
        while (durationMatcher.find()) {
            int duration = Integer.parseInt(durationMatcher.group(1));
            String unit = durationMatcher.group(2);
            int days = unit.equals("month") ? duration * 30 : duration * 365;
            binaryDays.add(Integer.toBinaryString(days));
        }

        // Extract and encode medical terms
        List<String> base36Terms = new ArrayList<>();
        Pattern termPattern = Pattern.compile("\\b(alopecia|androgenetic)\\b");
        Matcher termMatcher = termPattern.matcher(transcript);
        while (termMatcher.find()) {
            String term = termMatcher.group(1);
            StringBuilder encoded = new StringBuilder();
            for (char c : term.toCharArray()) {
                encoded.append(Integer.toString((int) c, 36).toUpperCase());
            }
            base36Terms.add(encoded.toString());
        }

        // Extract dates and convert to octal Unix timestamp
        List<String> octalDates = new ArrayList<>();
        Pattern datePattern = Pattern.compile("\\b(\\d{4}-\\d{2}-\\d{2}|\\w+ \\d{1,2}, \\d{4})\\b");
        Matcher dateMatcher = datePattern.matcher(transcript);
        while (dateMatcher.find()) {
            String dateStr = dateMatcher.group(1);
            LocalDate date;
            if (dateStr.contains("-")) {
                date = LocalDate.parse(dateStr);
            } else {
                date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH));
            }
            long unixTimestamp = date.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
            octalDates.add(Long.toOctalString(unixTimestamp));
        }

        // Combine all extracted and converted information
        return String.join(",", hexPercentages) + "|" +
               String.join(",", binaryDays) + "|" +
               String.join(",", base36Terms) + "|" +
               String.join(",", octalDates);
    }
}
