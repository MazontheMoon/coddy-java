/*
Create a function named findTreeInPark that receives parkTrees and searchTree as its parameters.

This function determines if a specific tree exists within a park.

Implement a function that accepts two parameters: parkTrees, an array of strings representing the names of trees in the park, and searchTree, a string representing the name of the tree you're searching for.

Your function should iterate through the parkTrees array and check if the searchTree exists within the array. If the searchTree is found, the function should return true. Otherwise, it should return false.

Parameters:
- parkTrees (String[]): An array of strings representing the names of trees in the park.
- searchTree (String): The name of the tree to search for within the parkTrees array.

The function returns a boolean value:
- true if searchTree is found within the parkTrees array.
- false if searchTree is not found within the parkTrees array.
 */

class FindTreeInPark {
    public static boolean findTreeInPark(String[] parkTrees, String searchTree) {
        for (String tree : parkTrees) {
            if (tree.equals(searchTree)) {
                return true;
            }
        }
        return false;
    }
}
