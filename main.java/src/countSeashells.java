/*
Create a function named countSeashells that receives beachSection as its parameter.

This function counts the number of seashells (represented by "*") in the given beachSection string.

Parameters:
- beachSection (String): A string where "o" represents sand and "*" represents a seashell.
The function returns an integer representing the total count of seashells in the given beachSection.
*/

class CountSeashells {
    public static int countSeashells(String beachSection) {
        int count = 0;
        for (char c : beachSection.toCharArray()) {
            if (c == '*') {
                count++;
            }
        }
        return count;
    }
}
