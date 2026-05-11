class CareerTransition {
    public static String careerTransition(int days) {
        int linesOfCode = 0;
        int conceptsLearned = 0;
        
        for (int day = 1; day <= days; day++) {
            if (day % 7 == 0) {
                continue; // Shoesmith takes a break on days divisible by 7
            }
            
            linesOfCode += 10; // Writes 10 lines of code each day
            
            if (day % 3 == 0) {
                conceptsLearned++; // Learns a new concept every 3 days
            }
            
            if (conceptsLearned == 5) {
                break; // Breakthrough achieved, learning process ends
            }
        }
        
        return "The shoesmith wrote " + linesOfCode + " lines of code and learned " + conceptsLearned + " programming concepts.";
    }
}
