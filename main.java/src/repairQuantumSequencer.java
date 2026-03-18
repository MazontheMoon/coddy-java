6class RepairQuantumSequencer {
    public static int[] repairQuantumSequencer(int initialValue, int sequenceLength) {
        int[] sequence = new int[sequenceLength];
        sequence[0] = initialValue;
        
        for (int i = 1; i < sequenceLength; i++) {
            sequence[i] = (sequence[i - 1] * 5 + 1) % 1000;
        }
        
        return sequence;
    }
}