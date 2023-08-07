package SimilarityProject;

import java.util.Map;
import java.util.Set;

public class JaccardSimilarity implements SimilarityCalculator {
    @Override
    public double CalculateSimilarity(Map<String, Double> File1, Map<String, Double> File2) {
        Set<String> terms1 = File1.keySet();
        Set<String> terms2 = File2.keySet();

        int intersectionSize = 0;
        int unionSize = terms1.size() + terms2.size();

        for (String term : terms1) {
            if (terms2.contains(term)) {
                intersectionSize++;
                unionSize--; // Remove one count from the union for each common element
            }
        }

        double jaccardCoefficient = (double) intersectionSize / unionSize;
        return jaccardCoefficient;
    }
}
