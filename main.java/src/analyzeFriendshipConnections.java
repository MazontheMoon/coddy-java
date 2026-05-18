import java.util.*;
import java.util.stream.*;

class AnalyzeFriendshipConnections {
    public static String analyzeFriendshipConnections(String[] connections, String[] inquiries) {
        Map<String, Set<String>> friendships = new HashMap<>();

        // Parse connections
        for (String connection : connections) {
            String[] friends = connection.split("-");
            friendships.computeIfAbsent(friends[0], k -> new HashSet<>()).add(friends[1]);
            friendships.computeIfAbsent(friends[1], k -> new HashSet<>()).add(friends[0]);
        }

        StringBuilder result = new StringBuilder();

        for (String inquiry : inquiries) {
            if (inquiry.equals("all_friends")) {
                result.append("All friends: ").append(getAllFriends(friendships)).append("\n");
            } else if (inquiry.startsWith("direct_friends-")) {
                String friend = inquiry.substring("direct_friends-".length());
                result.append("Direct friends of ").append(friend).append(": ")
                      .append(getDirectFriends(friendships, friend)).append("\n");
            } else if (inquiry.startsWith("common_friends-")) {
                String[] friends = inquiry.substring("common_friends-".length()).split("-");
                result.append("Common friends of ").append(friends[0]).append(" and ").append(friends[1]).append(": ")
                      .append(getCommonFriends(friendships, friends[0], friends[1])).append("\n");
            }
        }

        return result.toString().trim();
    }

    private static String getAllFriends(Map<String, Set<String>> friendships) {
        return friendships.keySet().stream().sorted().collect(Collectors.joining(", "));
    }

    private static String getDirectFriends(Map<String, Set<String>> friendships, String friend) {
        Set<String> directFriends = friendships.getOrDefault(friend, new HashSet<>());
        return directFriends.stream().sorted().collect(Collectors.joining(", "));
    }

    private static String getCommonFriends(Map<String, Set<String>> friendships, String friend1, String friend2) {
        Set<String> friends1 = friendships.getOrDefault(friend1, new HashSet<>());
        Set<String> friends2 = friendships.getOrDefault(friend2, new HashSet<>());
        Set<String> commonFriends = new HashSet<>(friends1);
        commonFriends.retainAll(friends2);
        return commonFriends.stream().sorted().collect(Collectors.joining(", "));
    }
}
