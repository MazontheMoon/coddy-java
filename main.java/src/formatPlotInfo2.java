class FormatPlotInfo {
    public static String formatPlotInfo(String plotCode, String plantName, String date) {
        String letter = plotCode.substring(0, 1);
        String number = plotCode.substring(1);
        return "Plot " + letter + "-" + number + ": " + plantName + " on " + date;
    }
}
