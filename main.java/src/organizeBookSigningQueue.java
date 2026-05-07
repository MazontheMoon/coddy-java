import java.util.*;

class OrganizeBookSigningQueue {
    public static String organizeBookSigningQueue(String[] attendees, int maxBooksPerPerson) {
        List<String> queue = new ArrayList<>(Arrays.asList(attendees));
        Set<String> uniqueAttendees = new LinkedHashSet<>();

        // Organize the queue
        Collections.sort(queue, (a, b) -> {
            if (a.startsWith("VIP_") && !b.startsWith("VIP_")) return -1;
            if (!a.startsWith("VIP_") && b.startsWith("VIP_")) return 1;
            if (a.startsWith("John ") && !b.startsWith("John ")) return -1;
            if (!a.startsWith("John ") && b.startsWith("John ")) return 1;
            return a.compareTo(b);
        });

        // Remove duplicates
        uniqueAttendees.addAll(queue);
        queue = new ArrayList<>(uniqueAttendees);

        int attendeesServed = 0;
        int booksSigned = 0;
        String lastPersonServed = "";
        List<String> unfinishedRequests = new ArrayList<>();

        // Process the queue
        for (String attendee : queue) {
            int booksForAttendee = Math.min(maxBooksPerPerson, 100 - booksSigned);
            if (booksForAttendee > 0) {
                attendeesServed++;
                booksSigned += booksForAttendee;
                lastPersonServed = attendee;
                if (booksForAttendee < maxBooksPerPerson) {
                    unfinishedRequests.add(attendee);
                }
            } else {
                unfinishedRequests.add(attendee);
            }
            if (booksSigned >= 100) break;
        }

        // Prepare the summary
        StringBuilder summary = new StringBuilder();
        summary.append("Attendees served: ").append(attendeesServed);
        summary.append(", Books signed: ").append(booksSigned);
        summary.append(", Last person served: ").append(lastPersonServed);
        if (!unfinishedRequests.isEmpty()) {
            summary.append(", Unfinished requests: ").append(String.join(", ", unfinishedRequests));
        }

        return summary.toString();
    }
}
