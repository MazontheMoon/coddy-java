class MergeCastLists {
    public static String[] mergeCastLists(String[] morningCast, String[] eveningCast) {
        // Calculate the total length of the combined array
        int totalLength = morningCast.length + eveningCast.length;
        String[] result = new String[totalLength];
        
        // Copy morning cast to result array
        for (int i = 0; i < morningCast.length; i++) {
            if (morningCast[i].isEmpty()) {
                result[i] = "TBA";
            } else {
                result[i] = morningCast[i];
            }
        }
        
        // Copy evening cast to result array
        for (int i = 0; i < eveningCast.length; i++) {
            if (eveningCast[i].isEmpty()) {
                result[morningCast.length + i] = "TBA";
            } else {
                result[morningCast.length + i] = eveningCast[i];
            }
        }
        
        return result;
    }
}
