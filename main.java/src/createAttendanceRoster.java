class CreateAttendanceRoster {
    public static String createAttendanceRoster(String[] memberNames) {
        StringBuilder roster = new StringBuilder();
        
        for (int i = 0; i < memberNames.length; i++) {
            roster.append((i + 1)).append(". ").append(memberNames[i]);
            if (i < memberNames.length - 1) {
                roster.append("\n");
            }
        }
        
        return roster.toString();
    }
}