package SimilarityProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the location of text file 1:");
        String filePath1 = sc.nextLine().replaceAll("^\"|\"$", "");
        String text1 = readFile(filePath1);

        System.out.println("Enter the location of text file 2:");
        String filePath2 = sc.nextLine().replaceAll("^\"|\"$", "");
        String text2 = readFile(filePath2);

        // Tokenize the text
        List<String> tokens1 = TFIDFProcessor.tokenizeText(text1);
        List<String> tokens2 = TFIDFProcessor.tokenizeText(text2);

        // Create a frequency map
        Map<String, Integer> freqMap1 = TFIDFProcessor.frequencyMap(tokens1);
        Map<String, Integer> freqMap2 = TFIDFProcessor.frequencyMap(tokens2);

        // Calculate TF-IDF
        Map<String, Double> tfIdf1 = TFIDFProcessor.calculateTFIDF(freqMap1, tokens1);
        Map<String, Double> tfIdf2 = TFIDFProcessor.calculateTFIDF(freqMap2, tokens2);

        // Choose the similarity calculator
        System.out.println("Select the similarity measure:");
        System.out.println("1. Cosine Similarity");
        System.out.println("2. Euclidean Similarity");
        System.out.println("3. Jaccard Similarity");
        System.out.println("4. Manhattan Distance");
        int choice = sc.nextInt();

        SimilarityCalculator calculator = SimilarityChoice.createCalculator(choice);

        if (calculator != null) {
            double similarity = calculator.CalculateSimilarity(tfIdf1, tfIdf2);
            System.out.println("Similarity: " + similarity);
        } else {
            System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + filePath);
            e.printStackTrace();
        }
        return content.toString();
    }
}
