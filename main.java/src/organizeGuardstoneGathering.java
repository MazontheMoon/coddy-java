import java.util.*;

class OrganizeGuardstoneGathering {
    public static String[][] organizeGuardstoneGathering(String[] participants, String[] roles, int circles) {
        // Create a list of Participant objects
        List<Participant> participantList = new ArrayList<>();
        for (int i = 0; i < participants.length; i++) {
            participantList.add(new Participant(participants[i], roles[i]));
        }

        // Sort participants based on roles and names
        Collections.sort(participantList, new ParticipantComparator());

        // Distribute participants into circles
        String[][] result = new String[circles][];
        int totalParticipants = participants.length;
        int remainingParticipants = totalParticipants;
        int currentIndex = 0;

        for (int i = 0; i < circles; i++) {
            int participantsInCircle = (remainingParticipants + circles - i - 1) / (circles - i);
            result[i] = new String[participantsInCircle];

            for (int j = 0; j < participantsInCircle; j++) {
                result[i][j] = participantList.get(currentIndex++).name;
            }

            remainingParticipants -= participantsInCircle;
        }

        return result;
    }

    private static class Participant {
        String name;
        String role;

        Participant(String name, String role) {
            this.name = name;
            this.role = role;
        }
    }

    private static class ParticipantComparator implements Comparator<Participant> {
        private static final Map<String, Integer> ROLE_PRIORITY = new HashMap<>();
        static {
            ROLE_PRIORITY.put("elder", 1);
            ROLE_PRIORITY.put("warrior", 2);
            ROLE_PRIORITY.put("healer", 3);
            ROLE_PRIORITY.put("craftsman", 4);
        }

        @Override
        public int compare(Participant p1, Participant p2) {
            int rolePriority1 = ROLE_PRIORITY.getOrDefault(p1.role.toLowerCase(), Integer.MAX_VALUE);
            int rolePriority2 = ROLE_PRIORITY.getOrDefault(p2.role.toLowerCase(), Integer.MAX_VALUE);

            if (rolePriority1 != rolePriority2) {
                return Integer.compare(rolePriority1, rolePriority2);
            }

            return p1.name.compareTo(p2.name);
        }
    }
}