import java.util.Arrays;

class DebateOutcome {
    public static String debateOutcome(String philosophy1, String philosophy2, String[] team1, String[] team2) {
        String betterPhilosophy = philosophy1.length() >= philosophy2.length() ? philosophy1 : philosophy2;
        
        String[] allPlayers = new String[team1.length + team2.length];
        System.arraycopy(team1, 0, allPlayers, 0, team1.length);
        System.arraycopy(team2, 0, allPlayers, team1.length, team2.length);
        
        int totalPlayers = allPlayers.length;
        
        String playersList = String.join(", ", allPlayers);
        
        return String.format("Better philosophy: %s\nTotal players: %d\nAll players: %s", betterPhilosophy, totalPlayers, playersList);
    }
}
