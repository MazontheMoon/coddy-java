import java.util.Arrays;

class GenerateAdvancedMathLessonPlan {
    public static String generateAdvancedMathLessonPlan(String topic, int difficulty, int duration, String[] conceptsToInclude, float[] constants) {
        StringBuilder lessonPlan = new StringBuilder();

        // Introduction
        lessonPlan.append("Advanced Mathematics Lesson Plan\n");
        lessonPlan.append("Topic: ").append(topic).append("\n");
        lessonPlan.append("Difficulty: ").append(difficulty).append("/5\n");
        lessonPlan.append("Duration: ").append(duration).append(" minutes\n\n");

        // Main topic introduction
        lessonPlan.append("1. Introduction to ").append(topic).append(":\n");
        lessonPlan.append("   - Overview of ").append(topic).append(" and its significance in advanced mathematics\n");
        lessonPlan.append("   - Historical context and key contributors\n\n");

        // Subtopics and concepts
        lessonPlan.append("2. Subtopics and Concepts:\n");
        for (int i = 0; i < conceptsToInclude.length; i++) {
            lessonPlan.append("   ").append((char)('a' + i)).append(") ").append(conceptsToInclude[i]).append("\n");
        }
        lessonPlan.append("\n");

        // Example problems
        lessonPlan.append("3. Example Problems:\n");
        for (int i = 0; i < Math.min(constants.length, 3); i++) {
            lessonPlan.append("   Problem ").append(i + 1).append(": ");
            switch (i) {
                case 0:
                    lessonPlan.append("Calculate the integral of e^(ix) around the unit circle using ").append(conceptsToInclude[0]).append(".\n");
                    lessonPlan.append("   Hint: Use the constant ").append(constants[i]).append(" in your solution.\n");
                    break;
                case 1:
                    lessonPlan.append("Find the residue of the function f(z) = 1 / (z^2 + 1) at z = i using the ").append(conceptsToInclude[1]).append(".\n");
                    lessonPlan.append("   Hint: The constant ").append(constants[i]).append(" may be useful in simplification.\n");
                    break;
                case 2:
                    lessonPlan.append("Develop a ").append(conceptsToInclude[2]).append(" for the function f(z) = sin(1/z) around z = 0.\n");
                    lessonPlan.append("   Hint: Consider using the constant ").append(constants[i]).append(" in your expansion.\n");
                    break;
            }
        }
        lessonPlan.append("\n");

        // Advanced operations and formulas
        lessonPlan.append("4. Advanced Operations and Formulas:\n");
        lessonPlan.append("   - Complex differentiation and integration techniques\n");
        lessonPlan.append("   - Application of ").append(conceptsToInclude[0]).append(" in solving complex integrals\n");
        lessonPlan.append("   - Techniques for finding residues and applying the ").append(conceptsToInclude[1]).append("\n");
        lessonPlan.append("   - Methods for developing and analyzing ").append(conceptsToInclude[2]).append("\n\n");

        // Mini-quiz
        lessonPlan.append("5. Mini-Quiz:\n");
        lessonPlan.append("   Q1 (Easy): State the ").append(conceptsToInclude[0]).append(" and explain its significance.\n");
        lessonPlan.append("   Q2 (Medium): How does the ").append(conceptsToInclude[1]).append(" simplify the calculation of certain complex integrals?\n");
        lessonPlan.append("   Q3 (Difficult): Develop a ").append(conceptsToInclude[2]).append(" for the function f(z) = e^(1/z) around z = ∞ up to the third term.\n");

        return lessonPlan.toString();
    }

    private static double gcd(double a, double b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
