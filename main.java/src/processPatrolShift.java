class ProcessPatrolShift {
    public static String processPatrolShift(String patrolRoute, int patrolId, int shiftChange) {
        // Update patrol ID with shift change
        int updatedId = patrolId + shiftChange;
        
        // Extract and reverse neighborhood codes (uppercase letters)
        StringBuilder reversedCodes = new StringBuilder();
        StringBuilder currentCode = new StringBuilder();
        
        for (char c : patrolRoute.toCharArray()) {
            if (Character.isUpperCase(c)) {
                currentCode.append(c);
            } else {
                if (currentCode.length() > 0) {
                    reversedCodes.append(currentCode.reverse());
                    currentCode = new StringBuilder();
                }
            }
        }
        
        // Handle the last code if it exists
        if (currentCode.length() > 0) {
            reversedCodes.append(currentCode.reverse());
        }
        
        // Format and return the patrol report
        return "Patrol-" + updatedId + ": " + reversedCodes.toString();
    }
}
