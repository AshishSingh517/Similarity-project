
Similarity Project 

The SimilarityProject is a Java project that calculates and compares the similarity between two text documents using various similarity measures such as Cosine Similarity, Euclidean Distance, Jaccard Similarity, and Manhattan Distance. The project consists of several classes that handle text processing, similarity calculations, and user interactions.

SimilarityCalculator Interface- 
The SimilarityCalculator interface defines a common contract for similarity calculation classes. It requires the implementation of the CalculateSimilarity method, which takes two Map<String, Double> instances representing term-frequency-inverse-document-frequency (TF-IDF) vectors of two text documents and returns a similarity score.

CosineSimilarity Class- 
The CosineSimilarity class implements the SimilarityCalculator interface and calculates the cosine similarity between two TF-IDF vectors. It computes the dot product of the vectors and divides it by the product of their magnitudes.

EuclideanDistance Class- 
The EuclideanDistance class implements the SimilarityCalculator interface and calculates the Euclidean distance between two TF-IDF vectors. It computes the squared differences between corresponding components of the vectors and returns the square root of the sum of these squared differences.

JaccardSimilarity Class- 
The JaccardSimilarity class implements the SimilarityCalculator interface and calculates the Jaccard similarity coefficient between two TF-IDF vectors. It computes the size of the intersection of the sets of terms and divides it by the size of the union of the sets.

ManhattanDistance Class- 
The ManhattanDistance class implements the SimilarityCalculator interface and calculates the Manhattan distance between two TF-IDF vectors. It computes the absolute differences between corresponding components of the vectors and returns the sum of these absolute differences.

SimilarityChoice Class- 
The SimilarityChoice class provides a factory method createCalculator to create instances of different similarity calculator classes based on the user's choice.

TFIDFProcessor Class- 
The TFIDFProcessor class handles the processing of TF-IDF values for a given list of tokens and frequency maps. It provides methods to calculate term frequencies, TF-IDF values, and tokenization of input text.

Main Class- 
The Main class contains the main entry point of the program. It interacts with the user, reads two text files, tokenizes the text, calculates TF-IDF values, prompts the user to select a similarity measure, and calculates the similarity score using the chosen measure.

*How to Use

-Compile and run the Main class.

-Enter the paths of the two text files that you want to compare

-Choose a similarity measure (Cosine Similarity, Euclidean Distance, Jaccard Similarity, or Manhattan Distance).

-The program will calculate and display the similarity score between the two text documents using the selected measure.
