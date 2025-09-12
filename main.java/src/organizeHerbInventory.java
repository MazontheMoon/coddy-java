/*
Create a function named organizeHerbInventory that receives herbs as its parameter.

The function helps a mysterious herbalist organize their inventory in their ancient apothecary shop. It takes a comma-separated list of herb names and returns a formatted inventory list.

Parameters:
 - herbs (String): A comma-separated list of herb names. The names may have leading/trailing spaces and mixed case.

The function should perform the following tasks:
- Split the input string into individual herb names.
- Trim any leading or trailing spaces from each herb name.
- Capitalize the first letter of each herb name.
- Create a numbered list of the herbs, with each herb on a new line.

The function returns a String representing the formatted inventory list.
*/
public class organizeHerbInventory {
    public static String organizeHerbInventory(String herbs) {
        String[] herbArray = herbs.split(",");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < herbArray.length; i++) {
            String herb = herbArray[i].trim();
            herb = herb.substring(0, 1).toUpperCase() + herb.substring(1).toLowerCase();
            result.append(i + 1).append(". ").append(herb);
            if (i < herbArray.length - 1) {
                result.append("\n");
            }
        }

        return result.toString();
    }
}
