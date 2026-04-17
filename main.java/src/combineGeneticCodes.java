import java.util.Arrays;

class CombineGeneticCodes {
    public static int[] combineGeneticCodes(int[] parent1Genes, int[] parent2Genes, int mutationFactor) {
        int offspringLength = parent1Genes.length + parent2Genes.length;
        int[] offspringGenes = new int[offspringLength];
        
        int parent1Index = 0;
        int parent2Index = 0;
        
        for (int i = 0; i < offspringLength; i++) {
            if (i % 2 == 0 && parent1Index < parent1Genes.length) {
                offspringGenes[i] = parent1Genes[parent1Index++];
            } else if (parent2Index < parent2Genes.length) {
                offspringGenes[i] = parent2Genes[parent2Index++];
            } else {
                offspringGenes[i] = parent1Genes[parent1Index++];
            }
            
            if ((i + 1) % 3 == 0) {
                if (offspringGenes[i] % 2 == 0) {
                    offspringGenes[i] += mutationFactor;
                } else {
                    offspringGenes[i] -= mutationFactor;
                }
                
                if (offspringGenes[i] < 0) {
                    offspringGenes[i] = 0;
                }
            }
        }
        
        return offspringGenes;
    }
}
