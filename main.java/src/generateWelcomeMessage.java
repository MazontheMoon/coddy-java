class GenerateWelcomeMessage {
    public static String generateWelcomeMessage(String name, int age, boolean hasAppointment) {
        if (hasAppointment) {
            if (age < 18) {
                return "Ah, wee " + name + "! We've been expectin' ye. Right this way to your appointment, young one!";
            } else {
                return "Welcome " + name + "! Thank ye for makin' an appointment. Please head to the reception.";
            }
        } else {
            return "Hello " + name + "! How can we assist ye today at our hospital?";
        }
    }
}