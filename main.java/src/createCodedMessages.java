class CreateCodedMessages {
    public static String[][] createCodedMessages(String[][] headlines) {
        String[][] codedMessages = new String[headlines.length][];
        
        for (int i = 0; i < headlines.length; i++) {
            codedMessages[i] = new String[headlines[i].length];
            for (int j = 0; j < headlines[i].length; j++) {
                codedMessages[i][j] = reverseString(headlines[i][j]);
            }
        }
        
        return codedMessages;
    }
    
    private static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
}
