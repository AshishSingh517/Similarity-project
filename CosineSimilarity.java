package SimilarityProject;

import java.util.Map;

public class CosineSimilarity implements SimilarityCalculator {
    @Override
    public double CalculateSimilarity(Map<String, Double> File1, Map<String, Double> File2) {
        double dotProduct = 0;
        double magnitude1 = 0;
        double magnitude2 = 0;

        // Calculate dot product and magnitudes
        for (String term : File1.keySet()) {
            if (File2.containsKey(term)) {
                double file1 = File1.get(term);
                double file2 = File2.get(term);

                dotProduct += file1 * file2;
            }
            magnitude1 += Math.pow(File1.get(term), 2);

        }
        for (double file : File2.values()) {
            magnitude2 += Math.pow(file, 2);
        }

        // Calculate cosine similarity
        if (magnitude1 != 0.0 && magnitude2 != 0.0) {
            return dotProduct / (Math.sqrt(magnitude1) * Math.sqrt(magnitude2));
        } else {
            return 0.0;
        }
    }
}

