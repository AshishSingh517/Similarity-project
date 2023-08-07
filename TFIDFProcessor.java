package SimilarityProject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TFIDFProcessor {
    private static final int TotalDocuments = 2;
    public static Map<String, Integer> frequencyMap(List<String> tokens) {
        Map<String, Integer> createmap = new HashMap<>();
        for (String words : tokens) {
            createmap.put(words, createmap.getOrDefault(words, 0) + 1);
        }
        return createmap;
    }

    public static Map<String, Double> calculateTFIDF(Map<String, Integer> frequencyMap, List<String> tokens) {
        Map<String, Double> tfIdfMap = new HashMap<>();

        for (String term : tokens) {
            int termFrequency = frequencyMap.get(term);
            double tf = (double) termFrequency / tokens.size();

            int documentFrequency = getDocumentFrequency(term, frequencyMap);
            double idf = Math.log((double) TotalDocuments / (documentFrequency + 1));

            double tfIdf = tf * idf;
            tfIdfMap.put(term, tfIdf);
        }

        return tfIdfMap;
    }
    public static List<String> tokenizeText(String text) {
        String[] terms = text.toLowerCase().split(" ");
        return Arrays.asList(terms);
    }
    private static int getDocumentFrequency(String term, Map<String, Integer> frequencyMap) {
        int documentFrequency = 0;
        for (Integer frequency : frequencyMap.values()) {
            if (frequency > 0) {
                documentFrequency++;
            }
        }
        return documentFrequency;
    }
}

