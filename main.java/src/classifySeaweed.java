class ClassifySeaweed {
    public static String classifySeaweed(int length, int branches, boolean hasAirBladders) {
        if (length > 50 && branches > 10) {
            return "Rhexia";
        } else if (hasAirBladders || length < 30) {
            return "Desmarestia";
        } else if (length >= 30 && length <= 50 && branches >= 5 && branches <= 10) {
            return "Unknown Species A";
        } else {
            return "Unknown Species B";
        }
    }
}
