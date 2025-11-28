import java.util.HashMap;

class ClassifyHandBones {
    public static String[] classifyHandBones(int[] boneLengths, String[] boneShapes, int[] jointCounts) {
        String[] classifications = new String[boneLengths.length];
        HashMap<Integer, String> classificationMap = new HashMap<>();

        for (int i = 0; i < boneLengths.length; i++) {
            int hash = hashBone(boneLengths[i], boneShapes[i], jointCounts[i]);
            String classification = classificationMap.get(hash);

            if (classification == null) {
                classification = classifyBone(boneLengths[i], boneShapes[i], jointCounts[i]);
                classificationMap.put(hash, classification);
            }

            classifications[i] = classification;
        }

        return classifications;
    }

    private static int hashBone(int length, String shape, int jointCount) {
        return length * 31 + shape.hashCode() * 17 + jointCount * 13;
    }

    private static String classifyBone(int length, String shape, int jointCount) {
        if (shape.equals("irregular")) {
            return "Carpal";
        }

        if (length > 40 && jointCount > 2) {
            return "Metacarpal";
        }

        if (length >= 20 && length <= 40 && jointCount == 2) {
            return "Proximal Phalanx";
        }

        if (length >= 15 && length <= 25 && jointCount == 1) {
            return "Middle Phalanx";
        }

        if (length < 20 && jointCount == 1) {
            return "Distal Phalanx";
        }

        return "Unknown";
    }
}