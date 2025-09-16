/*
Create a function named calculateDocumentPages that receives sections and lawOfficeNumber as its parameters.

As a lawyer preparing documents in a dusty office during a quiet subperiod of the workday, you need to calculate the total number of pages in a legal document based on the number of sections and a special "law office" number.

Calculate the total number of pages using the following rules:
- Each section has a base of 5 pages.
- The "law office" number is added to each section's page count.
- If the section number is even, add 2 extra pages for that section.
- If the section number is divisible by 3, add 1 extra page for that section.
- The total number of pages is the sum of all section page counts.

Parameters:
- sections (int): The number of sections in the legal document. It will be a positive integer.
- lawOfficeNumber (int): A special number between 1 and 10 (inclusive) representing the "law office" number.

The function returns an integer representing the total number of pages in the document.
*/

class CalculateDocumentPages {
    public static int calculateDocumentPages(int sections, int lawOfficeNumber) {
        int totalPages = 0;

        for (int i = 1; i <= sections; i++) {
            int sectionPages = 5 + lawOfficeNumber;

            if (i % 2 == 0) {
                sectionPages += 2;
            }

            if (i % 3 == 0) {
                sectionPages += 1;
            }

            totalPages += sectionPages;
        }

        return totalPages;
    }
}