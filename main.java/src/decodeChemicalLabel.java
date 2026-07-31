import java.util.HashMap;
import java.util.Map;

class DecodeChemicalLabel {
    public static String decodeChemicalLabel(String[] chemicalLabels, String[] chemicalsOrder) {
        Map<String, String> decodedChemicals = new HashMap<>();

        for (String label : chemicalLabels) {
            String reversedLabel = new StringBuilder(label).reverse().toString();
            decodedChemicals.put(reversedLabel, label);
        }

        StringBuilder result = new StringBuilder();

        for (String chemical : chemicalsOrder) {
            String decodedChemical = decodedChemicals.get(chemical);
            result.append(decodedChemical);
        }

        return result.toString();
    }
}
