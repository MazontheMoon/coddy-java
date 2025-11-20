/*
Create a function named manageAntiques that receives artifactNames, artifactDescriptions, artifactAges, and searchQuery as its parameters.

Your task is to implement an inventory management system for a mysterious antique shop. The function should organize the artifacts, implement efficient search capabilities, and return matching artifacts based on a search query.

Follow these steps to implement the function:
- Create a custom data structure to store the artifact information efficiently. Use a combination of a linked list and arrays.
- Implement a hashing technique to enable quick access to artifacts based on their names.
- Develop a substring search algorithm to find artifacts whose descriptions contain the search query.
Return an array of artifact names that match the search query, sorted by their age in descending order.

Parameters:
- artifactNames (String[]): An array of artifact names.
- artifactDescriptions (String[]): An array of artifact descriptions (in the same order as names).
- artifactAges (int[]): An array representing the age of artifacts in years (in the same order as names).
- searchQuery (String): A string representing the search query to find matching artifacts.
The function returns a String array containing the names of artifacts that match the search query, sorted by their age in descending order.

Important Notes:
- Ensure that your implementation handles cases where no artifacts match the search query.
- The search should be case-insensitive.
- If multiple artifacts have the same age, maintain their original order in the sorted result.
Implement the function efficiently, considering the constraints of the antique shop's inventory system.
*/

import java.util.*;

class ManageAntiques {
    private static class Artifact {
        String name;
        String description;
        int age;
        Artifact next;

        Artifact(String name, String description, int age) {
            this.name = name;
            this.description = description;
            this.age = age;
            this.next = null;
        }
    }

    private static class ArtifactList {
        Artifact head;

        void add(Artifact artifact) {
            if (head == null) {
                head = artifact;
            } else {
                Artifact current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = artifact;
            }
        }
    }

    public static String[] manageAntiques(String[] artifactNames, String[] artifactDescriptions, int[] artifactAges, String searchQuery) {
        Map<Integer, ArtifactList> hashTable = new HashMap<>();
        List<Artifact> matchingArtifacts = new ArrayList<>();

        // Create hash table and linked lists
        for (int i = 0; i < artifactNames.length; i++) {
            Artifact artifact = new Artifact(artifactNames[i], artifactDescriptions[i], artifactAges[i]);
            int hash = artifactNames[i].toLowerCase().hashCode() % 10;
            hashTable.computeIfAbsent(hash, k -> new ArtifactList()).add(artifact);
        }

        // Search for matching artifacts
        searchQuery = searchQuery.toLowerCase();
        for (ArtifactList list : hashTable.values()) {
            Artifact current = list.head;
            while (current != null) {
                if (current.name.toLowerCase().contains(searchQuery) ||
                        current.description.toLowerCase().contains(searchQuery)) {
                    matchingArtifacts.add(current);
                }
                current = current.next;
            }
        }

        // Sort matching artifacts by age in descending order
        Collections.sort(matchingArtifacts, (a1, a2) -> Integer.compare(a2.age, a1.age));

        // Extract names of matching artifacts
        String[] result = new String[matchingArtifacts.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = matchingArtifacts.get(i).name;
        }

        return result;
    }
}