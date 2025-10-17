/*
Create a function named calculatePicnicSupplies that receives sandwichesPerPerson, drinksPerPerson, fruitsPerPerson, and totalPeople as its parameters.

This function aims to calculate the total number of items needed for a family picnic based on the number of people attending and the quantity of each item per person.

To determine the total items, multiply each item's per-person quantity by the total number of people and sum the results:
- Total sandwiches = sandwichesPerPerson × totalPeople
- Total drinks = drinksPerPerson × totalPeople
- Total fruits = fruitsPerPerson × totalPeople
After calculating the total for each item, add them together to get the overall total number of items needed for the picnic.

Finally, return a string message in the format: "You will need X items for the picnic.", where X is the total number of items.

Parameters:
- sandwichesPerPerson (int): The number of sandwiches each person needs.
- drinksPerPerson (int): The number of drinks each person needs.
- fruitsPerPerson (int): The number of fruits each person needs.
- totalPeople (int): The total number of people attending the picnic.
The function returns a string representing the total number of items needed for the picnic, formatted as specified above.
 */

class CalculatePicnicSupplies {
    public static String calculatePicnicSupplies(int sandwichesPerPerson, int drinksPerPerson, int fruitsPerPerson, int totalPeople) {
        int totalSandwiches = sandwichesPerPerson * totalPeople;
        int totalDrinks = drinksPerPerson * totalPeople;
        int totalFruits = fruitsPerPerson * totalPeople;

        int totalItems = totalSandwiches + totalDrinks + totalFruits;

        return "You will need " + totalItems + " items for the picnic.";
    }
}