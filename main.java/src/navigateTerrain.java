/*
Create a function named navigateTerrain that receives fragments as its parameter.

This function aims to piece together the fragmented substrings of a route and create a complete, safe passage through a treacherous terrain.

To construct the complete route, concatenate the fragments in the correct order by finding the overlapping parts between them.

For example, if the fragments are ["start-forest-", "-mountain-v", "alley-end"], the complete route becomes "start-forest-mountain-valley-end".

If there are no overlaps between the fragments, return "INVALID".

Parameter:
- fragments (String[]): An array of strings representing the fragmented substrings of the route.

The function returns a string representing the complete and correct path through the terrain, constructed by concatenating the fragments in the correct order. If the route cannot be reconstructed, it returns "INVALID".
 */

class NavigateTerrain {
    public static String navigateTerrain(String[] fragments) {
        String route = fragments[0];
        for (int i = 1; i < fragments.length; i++) {
            String fragment = fragments[i];
            int overlapIndex = route.indexOf(fragment.substring(0, fragment.length() - 1));
            if (overlapIndex != -1) {
                route = route.substring(0, overlapIndex) + fragment;
            } else {
                return "INVALID";
            }
        }
        return route;
    }
}