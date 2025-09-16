/*
Create a function named organizeLabCompartments that receives compartmentLabels as its parameter.

You are a scientist in a cluttered laboratory where experiments are stored in various compartments. To clean up the lab, you need to reverse the order of the compartments and combine their labels. Your task is to create a function that takes an array of strings (representing compartment labels) and returns a single string with the labels reversed and concatenated.

Parameters:
- compartmentLabels (String[]): An array containing labels of experiment compartments. The array will have between 1 and 10 elements.

The function should return a single string where the compartment labels are reversed and concatenated without any separators.

For example:
- If the input is ["DNA", "RNA", "Proteins", "Lipids"], the output should be "LipidsProteinsRNADNA".
- If the input is ["Microscope", "Petri Dish", "Test Tube"], the output should be "Test TubePetri DishMicroscope".
- Remember to reverse the order of the labels and then concatenate them without adding any extra characters between the labels.
*/

class OrganizeLabCompartments {
    public static String organizeLabCompartments(String[] compartmentLabels) {
        StringBuilder result = new StringBuilder();
        for (int i = compartmentLabels.length - 1; i >= 0; i--) {
            result.append(compartmentLabels[i]);
        }
        return result.toString();
    }
}