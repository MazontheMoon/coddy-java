/*
Create a function named prepareSupplyPackages that receives patientNeeds and maxSupplies as its parameters.

You are working in a busy medical clinic where doctors need to prepare packages of medical supplies for patients. Your task is to implement a system that efficiently allocates supplies based on patient needs and available inventory.

The function should distribute supplies to patients, creating as many complete packages as possible without exceeding the available inventory. It should stop when either the inventory is depleted or all patients have been served.

Parameters:
- patientNeeds (int[]): An array where each element represents the number of supplies needed for a patient. Each value will be between 1 and 100.
- maxSupplies (int): The maximum number of supplies available in the clinic's inventory. This value will be between 1 and 1000.

The function returns an integer array where each element represents the number of supplies given to each patient. If a patient doesn't receive a package due to inventory constraints, the corresponding element should be 0.

Important notes:
- You must serve patients in the order they appear in the patientNeeds array.
- You cannot partially fill a patient's need. Either provide the full amount of supplies requested or none at all.
- Use a loop to iterate through the patientNeeds array.
- Use control flow statements (like break or continue) to manage the supply distribution process.
 */

import java.util.Arrays;

class PrepareSupplyPackages {
    public static int[] prepareSupplyPackages(int[] patientNeeds, int maxSupplies) {
        int[] suppliesGiven = new int[patientNeeds.length];
        int remainingSupplies = maxSupplies;

        for (int i = 0; i < patientNeeds.length; i++) {
            if (remainingSupplies >= patientNeeds[i]) {
                suppliesGiven[i] = patientNeeds[i];
                remainingSupplies -= patientNeeds[i];
            } else {
                break;
            }
        }

        return suppliesGiven;
    }
}