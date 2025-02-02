package mulyo;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Enter the text to analyzed:");
        String word = scanner.nextLine();
        //System.out.println("Enter the word to be count");
       // String inputText2 = scanner.nextLine();

        Map<String, Integer> wordFrequencies = calculateWordFrequencies(word);
        //Map<String, Integer> wordFrequencies2= calculateWordFrequencies(inputText2);

        // Display the word frequencies
        System.out.println("The Word Frequencies are as follows:");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    private static Map<String, Integer> calculateWordFrequencies(String text) {
        // Normalize the text by converting it to lyrics and removing punctuation
        text = text.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");

        String[] words = text.split("\\s+");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordCountMap;
        
        // Program by: Cornelius Mulyokela
        // GO HATTERS
    }
}

