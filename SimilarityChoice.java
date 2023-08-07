package SimilarityProject;

public class SimilarityChoice {
    public static SimilarityCalculator createCalculator(int choice) {
        switch (choice) {
            case 1:
                return new CosineSimilarity();
            case 2:
                return new EuclideanDistance();
            case 3:
                return new JaccardSimilarity();
            case 4:
                return new ManhattanDistance();
            default:
                return null;
        }
    }
}


