package wordcounter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("........................................................");
        System.out.println("Enter '1' to input text manually or '2' to provide a file:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String text;
        if (choice == 1) {
            System.out.println("Enter your text:");
            text = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            try {
                text = readFromFile(filePath);
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
                System.out.println("........................................................");
                return;
            }
        } else {
            System.out.println("Invalid choice.");
            return;
        }
        int wordCount = countWords(text);
        System.out.println("Total words: " + wordCount);
        System.out.println("........................................................");
    }

    private static String readFromFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    private static int countWords(String text) {
        String[] words = text.split("\\s+|\\p{Punct}");
        return words.length;
    }

}
