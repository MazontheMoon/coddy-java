import java.util.*;

class OptimizeSeating {
    public static String[][] optimizeSeating(int[][] roomLayout, String[] familyMembers) {
        int rows = roomLayout.length;
        int cols = roomLayout[0].length;
        String[][] seatingArrangement = new String[rows][cols];
        List<String> remainingMembers = new ArrayList<>(Arrays.asList(familyMembers));
        List<int[]> availableSeats = new ArrayList<>();

        // Initialize seating arrangement and find available seats
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (roomLayout[i][j] == 1) {
                    seatingArrangement[i][j] = "";
                    availableSeats.add(new int[]{i, j});
                } else {
                    seatingArrangement[i][j] = null;
                }
            }
        }

        // Sort family members by last name
        Collections.sort(remainingMembers, (a, b) -> a.split(" ")[1].compareTo(b.split(" ")[1]));

        // Seat extroverts
        for (int i = 0; i < Math.min(3, remainingMembers.size()); i++) {
            int index = i * (availableSeats.size() / 3);
            int[] seat = availableSeats.get(index);
            seatingArrangement[seat[0]][seat[1]] = remainingMembers.remove(0);
        }

        // Seat elderly
        for (int i = 0; i < Math.min(2, remainingMembers.size()); i++) {
            int[] seat = findComfortableSeat(availableSeats, seatingArrangement);
            seatingArrangement[seat[0]][seat[1]] = remainingMembers.remove(remainingMembers.size() - 1);
        }

        // Seat remaining family members
        for (String member : remainingMembers) {
            int[] seat = findBestSeat(availableSeats, seatingArrangement, member);
            seatingArrangement[seat[0]][seat[1]] = member;
        }

        return seatingArrangement;
    }

    private static int[] findComfortableSeat(List<int[]> availableSeats, String[][] seatingArrangement) {
        return availableSeats.stream()
                .filter(seat -> seatingArrangement[seat[0]][seat[1]].isEmpty())
                .min((a, b) -> Integer.compare(countNeighbors(a, seatingArrangement), countNeighbors(b, seatingArrangement)))
                .orElse(availableSeats.get(0));
    }

    private static int[] findBestSeat(List<int[]> availableSeats, String[][] seatingArrangement, String member) {
        String lastName = member.split(" ")[1];
        return availableSeats.stream()
                .filter(seat -> seatingArrangement[seat[0]][seat[1]].isEmpty())
                .max((a, b) -> Integer.compare(
                        scoreSeating(a, seatingArrangement, lastName),
                        scoreSeating(b, seatingArrangement, lastName)))
                .orElse(availableSeats.get(0));
    }

    private static int countNeighbors(int[] seat, String[][] seatingArrangement) {
        int count = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newRow = seat[0] + dir[0];
            int newCol = seat[1] + dir[1];
            if (newRow >= 0 && newRow < seatingArrangement.length &&
                newCol >= 0 && newCol < seatingArrangement[0].length &&
                seatingArrangement[newRow][newCol] != null &&
                !seatingArrangement[newRow][newCol].isEmpty()) {
                count++;
            }
        }
        return count;
    }

    private static int scoreSeating(int[] seat, String[][] seatingArrangement, String lastName) {
        int score = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int[] dir : directions) {
            int newRow = seat[0] + dir[0];
            int newCol = seat[1] + dir[1];
            if (newRow >= 0 && newRow < seatingArrangement.length &&
                newCol >= 0 && newCol < seatingArrangement[0].length &&
                seatingArrangement[newRow][newCol] != null &&
                !seatingArrangement[newRow][newCol].isEmpty()) {
                if (seatingArrangement[newRow][newCol].split(" ")[1].equals(lastName)) {
                    score += 2;
                } else {
                    score += 1;
                }
            }
        }
        return score;
    }
}
