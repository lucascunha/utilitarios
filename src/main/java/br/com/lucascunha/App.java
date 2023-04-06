package br.com.lucascunha;

public class App {
    public static void main(String[] args) {
        String input = "Hello, world!";
        String xxdOutput = generateXxdOutput(input);
        System.out.println(xxdOutput);
    }

    public static String generateXxdOutput(String input) {
        StringBuilder output = new StringBuilder();
        byte[] bytes = input.getBytes();
        int bytesPerLine = 16;
        
        for (int i = 0; i < bytes.length; i += bytesPerLine) {
            // Print the offset
            output.append(String.format("%08x: ", i));

            // Print the hexadecimal representation
            for (int j = i; j < i + bytesPerLine; j++) {
                if (j < bytes.length) {
                    output.append(String.format("%02x", bytes[j]));
                } else {
                    output.append("  ");
                }
                if (j % 2 == 1) {
                    output.append(" ");
                }
            }
            
            // Print the ASCII representation
            output.append(" ");
            for (int j = i; j < i + bytesPerLine && j < bytes.length; j++) {
                char c = (char) bytes[j];
                if (Character.isISOControl(c) || Character.isWhitespace(c)) {
                    output.append('.');
                } else {
                    output.append(c);
                }
            }
            output.append("\n");
        }
        return output.toString();
    }
}
