package SimilarityProject;

import java.util.Map;

public class ManhattanDistance implements SimilarityCalculator {
    @Override
    public double CalculateSimilarity(Map<String, Double> File1, Map<String, Double> File2) {
        double distance = 0.0;

        for (String term : File1.keySet()) {
            double file1 = File1.getOrDefault(term, 0.0);
            double file2 = File2.getOrDefault(term, 0.0);

            distance += Math.abs(file1 - file2);
        }

        return distance;
    }
}

