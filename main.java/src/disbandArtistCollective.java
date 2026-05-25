import java.util.LinkedList;

class DisbandArtistCollective {
    public static String disbandArtistCollective(String collective) {
        LinkedList<String> artists = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        // Parse the input string and create a linked list
        for (int i = 0; i < collective.length(); i += 7) {
            artists.add(collective.substring(i, i + 7));
        }

        int index = 0;
        while (!artists.isEmpty()) {
            // Add spaces for removed artists
            result.append("       ".repeat(index));

            // Remove every third artist
            index = (index + 2) % artists.size();
            result.append(artists.remove(index));
        }

        return result.toString();
    }
}
