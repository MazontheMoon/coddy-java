import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

class CalculateShadowLengths {
    public static String[] calculateShadowLengths(float[] objects, float[] latitudes, float[] longitudes, String date, String[] times) {
        LocalDate localDate = LocalDate.parse(date);
        int n = objects.length;
        int m = times.length;
        String[] result = new String[n * m];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                LocalTime localTime = LocalTime.parse(times[j]);
                double shadowLength = calculateShadowLength(objects[i], latitudes[i], longitudes[i], localDate, localTime);
                double shadowDirection = calculateShadowDirection(latitudes[i], longitudes[i], localDate, localTime);

                String binary = convertToBinary(shadowLength);
                String octal = convertToOctal(shadowLength);
                String hexadecimal = convertToHexadecimal(shadowLength);

                result[index] = String.format("Object %d, Time %s: Length %.2f (%s, %s, %s), Direction %.2f degrees",
                        i, times[j], shadowLength, binary, octal, hexadecimal, shadowDirection);
                index++;
            }
        }

        return result;
    }

    private static double calculateShadowLength(float objectHeight, float latitude, float longitude, LocalDate date, LocalTime time) {
        double solarElevation = calculateSolarElevation(latitude, longitude, date, time);
        return objectHeight / Math.tan(Math.toRadians(solarElevation));
    }

    private static double calculateShadowDirection(float latitude, float longitude, LocalDate date, LocalTime time) {
        double solarAzimuth = calculateSolarAzimuth(latitude, longitude, date, time);
        return (solarAzimuth + 180) % 360;
    }

    private static double calculateSolarElevation(float latitude, float longitude, LocalDate date, LocalTime time) {
        double declination = calculateSolarDeclination(date);
        double hourAngle = calculateHourAngle(longitude, date, time);
        double latRad = Math.toRadians(latitude);
        double decRad = Math.toRadians(declination);

        double sinElevation = Math.sin(latRad) * Math.sin(decRad) +
                Math.cos(latRad) * Math.cos(decRad) * Math.cos(hourAngle);
        return Math.toDegrees(Math.asin(sinElevation));
    }

    private static double calculateSolarAzimuth(float latitude, float longitude, LocalDate date, LocalTime time) {
        double declination = calculateSolarDeclination(date);
        double hourAngle = calculateHourAngle(longitude, date, time);
        double latRad = Math.toRadians(latitude);
        double decRad = Math.toRadians(declination);

        double cosAzimuth = (Math.sin(decRad) - Math.sin(latRad) * Math.sin(Math.asin(Math.sin(decRad)))) /
                (Math.cos(latRad) * Math.cos(Math.asin(Math.sin(decRad))));
        double azimuth = Math.toDegrees(Math.acos(cosAzimuth));

        if (hourAngle > 0) {
            azimuth = 360 - azimuth;
        }

        return azimuth;
    }

    private static double calculateSolarDeclination(LocalDate date) {
        int dayOfYear = date.getDayOfYear();
        return 23.45 * Math.sin(Math.toRadians((360.0 / 365) * (dayOfYear - 81)));
    }

    private static double calculateHourAngle(float longitude, LocalDate date, LocalTime time) {
        double solarNoon = calculateSolarNoon(longitude, date);
        double timeOffset = (time.toSecondOfDay() / 3600.0) - solarNoon;
        return Math.toRadians(15 * timeOffset);
    }

    private static double calculateSolarNoon(float longitude, LocalDate date) {
        int dayOfYear = date.getDayOfYear();
        double eqTime = 229.18 * (0.000075 + 0.001868 * Math.cos(Math.toRadians(dayOfYear)) -
                0.032077 * Math.sin(Math.toRadians(dayOfYear)) -
                0.014615 * Math.cos(Math.toRadians(2 * dayOfYear)) -
                0.040849 * Math.sin(Math.toRadians(2 * dayOfYear)));
        return 12 - eqTime / 60 - longitude / 15;
    }

    private static String convertToBinary(double value) {
        return "0b" + Long.toBinaryString(Double.doubleToRawLongBits(value));
    }

    private static String convertToOctal(double value) {
        return "0" + Long.toOctalString(Double.doubleToRawLongBits(value));
    }

    private static String convertToHexadecimal(double value) {
        return "0x" + Long.toHexString(Double.doubleToRawLongBits(value));
    }
}
