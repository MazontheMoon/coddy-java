import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class ScheduleDentalAppointment {
    public static String scheduleDentalAppointment(String patientName, int patientAge, String lastVisit, String requestedDate, String requestedTime, String treatmentType) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalDate lastVisitDate = LocalDate.parse(lastVisit, dateFormatter);
        LocalDate requestedAppointmentDate = LocalDate.parse(requestedDate, dateFormatter);
        LocalTime requestedAppointmentTime = LocalTime.parse(requestedTime, timeFormatter);

        long monthsSinceLastVisit = ChronoUnit.MONTHS.between(lastVisitDate, requestedAppointmentDate);
        boolean isDueForCleaning = monthsSinceLastVisit >= 6;

        boolean isWeekend = requestedAppointmentDate.getDayOfWeek().getValue() > 5;
        boolean isWithinBusinessHours = requestedAppointmentTime.isAfter(LocalTime.of(8, 59)) && requestedAppointmentTime.isBefore(LocalTime.of(17, 1));
        boolean isSlotAvailable = !isWeekend && isWithinBusinessHours;

        if (!isSlotAvailable) {
            requestedAppointmentTime = requestedAppointmentTime.plusMinutes(30);
            if (requestedAppointmentTime.isAfter(LocalTime.of(17, 0))) {
                requestedAppointmentDate = requestedAppointmentDate.plusDays(1);
                requestedAppointmentTime = LocalTime.of(9, 0);
            }
        }

        boolean isQualifiedForTreatment = !(treatmentType.equalsIgnoreCase("root canal") && patientAge < 18);

        StringBuilder confirmationMessage = new StringBuilder();
        confirmationMessage.append("Dear ").append(patientName).append(",\n\n");
        confirmationMessage.append("Your dental appointment has been scheduled for ");
        confirmationMessage.append(requestedAppointmentDate.format(dateFormatter)).append(" at ");
        confirmationMessage.append(requestedAppointmentTime.format(timeFormatter)).append(".\n");

        if (isQualifiedForTreatment) {
            confirmationMessage.append("Treatment: ").append(treatmentType);
            if (isDueForCleaning) {
                confirmationMessage.append(" and cleaning");
            }
            confirmationMessage.append(".\n");
        } else {
            confirmationMessage.append("We're sorry, but you don't qualify for the requested treatment. ");
            confirmationMessage.append("Please consult with our dentist for alternative options.\n");
        }

        if (isDueForCleaning) {
            confirmationMessage.append("Note: You are due for a routine cleaning.\n");
        }

        confirmationMessage.append("\nPlease arrive 15 minutes before your appointment time. ");
        confirmationMessage.append("If you need to reschedule, please call us at least 24 hours in advance.\n\n");
        confirmationMessage.append("We look forward to seeing you!\n");
        confirmationMessage.append("Dental Clinic Team");

        return confirmationMessage.toString();
    }
}