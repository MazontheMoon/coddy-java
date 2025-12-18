/*
Create a function named documentMedicalProcedure that receives String[] procedureSteps, String[] instruments, and int duration as its parameters.

As a meticulous historian (annalist) documenting a medical procedure, your task is to create a detailed and formatted report of the operation. You will need to analyze the procedure steps, instruments used (including the scalpel), and the duration of the operation.

Your function should process the inputs and generate a formatted report string using advanced increment and decrement operators, control flow techniques, and string formatting. Follow these specific requirements:

Iterate through the procedureSteps array using advanced increment or decrement operators.
Format each step by adding a step number at the beginning, starting from 1.
Use advanced control flow (e.g., break, continue) to skip any steps that contain the word "error" or are empty strings.
Format each step to be exactly 50 characters long. If a step is shorter, pad it with spaces. If it's longer, truncate it to 50 characters.
Create a section listing all instruments used, with special formatting for the scalpel (if present).
Include the duration of the procedure in the report.
Combine all formatted information into a single string for the final report.
Parameters:

procedureSteps (String[]): An array of strings where each string represents a step in the medical procedure.
instruments (String[]): An array of strings representing the instruments used in the procedure.
duration (int): An integer representing the duration of the procedure in minutes.
The function returns a string containing the formatted medical procedure report.

Here's an example of how the output should be formatted:
Procedure Report:
----------------
Steps:
1. Begin incision with scalpel at marked point.  
2. Retract skin and expose underlying tissue.   
3. Close incision with sutures.                 

Instruments Used:
- Scalpel (primary cutting instrument)
- Retractor
- Suture

Duration: 45 minutes

End of Report
*/

import java.util.Arrays;

class DocumentMedicalProcedure {
    public static String documentMedicalProcedure(String[] procedureSteps, String[] instruments, int duration) {
        StringBuilder report = new StringBuilder("Procedure Report:\n----------------\nSteps:\n");

        for (int i = 0; i < procedureSteps.length;) {
            String step = procedureSteps[i++];
            if (step.isEmpty() || step.toLowerCase().contains("error")) {
                continue;
            }
            String formattedStep = String.format("%d. %-48s", i, step);
            report.append(formattedStep.substring(0, Math.min(formattedStep.length(), 50))).append("\n");
        }

        report.append("\nInstruments Used:\n");
        for (String instrument : instruments) {
            if (instrument.equalsIgnoreCase("Scalpel")) {
                report.append("- Scalpel (primary cutting instrument)\n");
            } else {
                report.append("- ").append(instrument).append("\n");
            }
        }

        report.append("\nDuration: ").append(duration).append(" minutes\n\nEnd of Report");

        return report.toString();
    }
}
