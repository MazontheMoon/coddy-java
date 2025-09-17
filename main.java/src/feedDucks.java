/*
Create a function named feedDucks that receives initialDucks and breadPieces as its parameters.

During your lunch break at the zoo's botanical garden, you decide to feed the ducks in the pond. For every two pieces of bread you throw, a new duck is attracted to join the existing ducks. However, if you throw an odd number of bread pieces, the last piece doesn't attract a new duck.

Your task is to calculate the final number of ducks in the pond after feeding. Use increment and decrement operators, as well as basic variable assignments to solve this problem.

Parameters:
- initialDucks (int): The number of ducks initially in the pond.
- breadPieces (int): The number of bread pieces thrown into the pond.
The function returns an integer representing the final number of ducks in the pond after feeding.
*/

class FeedDucks {
    public static int feedDucks(int initialDucks, int breadPieces) {
        int finalDucks = initialDucks;
        int newDucks = breadPieces / 2;
        finalDucks += newDucks;
        return finalDucks;
    }
}