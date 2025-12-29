/*Write a function organizeFiles that takes String[] documents and returns String[][].

The function processes medical office document names, organizing them into patient and legal file groups while handling special processing rules.

Logic:

Process documents until "END" is encountered (use break to stop)
Skip invalid entries that don't start with "PATIENT" or "LEGAL" (use continue)
For valid files, reverse only the numeric ID portion in the filename
Group files by prefix and sort each group case-insensitively
Return as 2D array: first row contains patient files, second row contains legal files
Parameters:

documents (String[]): Array of document names to process
Returns: 2D string array with organized files. Format: [["PATIENT_321_history.txt", "PATIENT_654_records.txt"], ["LEGAL_987_contract.pdf", "LEGAL_543_agreement.pdf"]]*/

import java.util.*;

class OrganizeFiles {
    public static String[][] organizeFiles(String[] documents) {
        List<String> patientFiles = new ArrayList<>();
        List<String> legalFiles = new ArrayList<>();
        
        for (String document : documents) {
            if (document.equals("END")) {
                break;
            }
            
            if (!document.startsWith("PATIENT") && !document.startsWith("LEGAL")) {
                continue;
            }
            
            String processedFile = reverseNumericId(document);
            
            if (document.startsWith("PATIENT")) {
                patientFiles.add(processedFile);
            } else if (document.startsWith("LEGAL")) {
                legalFiles.add(processedFile);
            }
        }
        
        Collections.sort(patientFiles, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(legalFiles, String.CASE_INSENSITIVE_ORDER);
        
        String[][] result = new String[2][];
        result[0] = patientFiles.toArray(new String[0]);
        result[1] = legalFiles.toArray(new String[0]);
        
        return result;
    }
    
    private static String reverseNumericId(String filename) {
        // Find the numeric ID between underscores
        int firstUnderscore = filename.indexOf('_');
        int secondUnderscore = filename.indexOf('_', firstUnderscore + 1);
        
        if (firstUnderscore != -1 && secondUnderscore != -1) {
            String prefix = filename.substring(0, firstUnderscore + 1);
            String numericId = filename.substring(firstUnderscore + 1, secondUnderscore);
            String suffix = filename.substring(secondUnderscore);
            
            // Reverse the numeric ID
            String reversedId = new StringBuilder(numericId).reverse().toString();
            
            return prefix + reversedId + suffix;
        }
        
        return filename;
    }
}
