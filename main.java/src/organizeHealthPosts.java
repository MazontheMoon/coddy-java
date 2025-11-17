/*
Write a function organizeHealthPosts that takes posts, minEngagement, maxPosts and returns a map of categories to their highest engagement posts.

The function processes health bulletin board posts, filtering categories by minimum engagement and limiting total results.

Logic:
- Group posts by category using advanced loops
- For each category, use continue to skip if no post meets minEngagement threshold
- Find the highest engagement post in each valid category
- Use break to stop processing once maxPosts limit is reached
- Apply game-theoretic ranking where ties are broken by post content length (longer content wins)

Parameters:
- posts (String[]): Array where each element is "category:content:engagement" format
- minEngagement (int): Minimum engagement score required for a category to be included
- maxPosts (int): Maximum number of top posts to return across all categories
Returns: String representing the organized posts.
Format: category1:content1:engagement1 category2:content2:engagement2
 */

import java.util.*;

class OrganizeHealthPosts {
    public static String organizeHealthPosts(String[] posts, int minEngagement, int maxPosts) {
        Map<String, String> categoryToBestPost = new HashMap<>();
        Map<String, Integer> categoryToMaxEngagement = new HashMap<>();

        // Group posts by category and find the best post for each category
        for (String post : posts) {
            String[] parts = post.split(":");
            String category = parts[0];
            String content = parts[1];
            int engagement = Integer.parseInt(parts[2]);

            // Skip if engagement is below minimum threshold
            if (engagement < minEngagement) {
                continue;
            }

            // Check if this is the best post for this category
            if (!categoryToMaxEngagement.containsKey(category) ||
                    engagement > categoryToMaxEngagement.get(category) ||
                    (engagement == categoryToMaxEngagement.get(category) &&
                            content.length() > categoryToBestPost.get(category).split(":")[1].length())) {

                categoryToBestPost.put(category, post);
                categoryToMaxEngagement.put(category, engagement);
            }
        }

        // Convert to list and sort by engagement (descending), then by content length (descending) for ties
        List<String> sortedPosts = new ArrayList<>(categoryToBestPost.values());
        sortedPosts.sort((a, b) -> {
            String[] partsA = a.split(":");
            String[] partsB = b.split(":");
            int engagementA = Integer.parseInt(partsA[2]);
            int engagementB = Integer.parseInt(partsB[2]);

            if (engagementA != engagementB) {
                return Integer.compare(engagementB, engagementA); // Descending order
            }
            // Tie-breaker: longer content wins
            return Integer.compare(partsB[1].length(), partsA[1].length());
        });

        // Build result string with maxPosts limit
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (String post : sortedPosts) {
            if (count >= maxPosts) {
                break;
            }
            if (count > 0) {
                result.append("\n");
            }
            result.append(post);
            count++;
        }

        return result.toString();
    }
}