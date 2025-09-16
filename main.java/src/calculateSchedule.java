/*
Create a function named calculateSchedule that receives periodNumber as its parameter.

This function determines the starting time of a given period in the Tauris Elementary school schedule:

1: Mathematics (8:30 AM - 9:15 AM)
2: Language Arts (9:15 AM - 10:00 AM)
3: Science (10:00 AM - 10:45 AM)
4: Social Studies (10:45 AM - 11:30 AM)
5: Lunch Break (11:30 AM - 12:15 PM)
6: Physical Education (12:15 PM - 1:00 PM)
7: Art (1:00 PM - 1:45 PM)
8: Music (1:45 PM - 2:30 PM)

Given the periodNumber (1-7), return the starting time as a string in the format "H:MM AM" or "H:MM PM".
*/

class CalculateSchedule {
    public static String calculateSchedule(int periodNumber) {
        switch (periodNumber) {
            case 1:
                return "8:30 AM";
            case 2:
                return "9:15 AM";
            case 3:
                return "10:00 AM";
            case 4:
                return "10:45 AM";
            case 5:
                return "12:15 PM";
            case 6:
                return "1:00 PM";
            case 7:
                return "1:45 PM";
            default:
                return "";
        }
    }
}