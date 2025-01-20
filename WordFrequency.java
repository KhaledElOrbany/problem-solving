import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {

    public void findWordFrequencies() {
        String input = "apple banana apple orange banana apple orange orange";

        String[] words = input.split("\\s+");
        HashMap<String, Integer> wrod2Freq = new HashMap<>();

        for (String word : words) {
            wrod2Freq.put(word, wrod2Freq.getOrDefault(word, 0) + 1);
        }

        String mostFrequentWord = null;
        String leastFrequentWord = null;
        int maxFrequency = Integer.MIN_VALUE;
        int minFrequency = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : wrod2Freq.entrySet()) {
            int frequency = entry.getValue();
            String word = entry.getKey();

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequentWord = word;
            }

            if (frequency < minFrequency) {
                minFrequency = frequency;
                leastFrequentWord = word;
            }
        }

        System.out.println("Most Frequent Word: " + mostFrequentWord + " (Frequency: " + maxFrequency + ")");
        System.out.println("Least Frequent Word: " + leastFrequentWord + " (Frequency: " + minFrequency + ")");
    }

    public void printWordsByFrequency() {
        String input = "apple banana apple orange banana apple orange orange";
        String[] words = input.split("\\s+");

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> wordFrequencyList = new ArrayList<>(wordCountMap.entrySet());
        wordFrequencyList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        System.out.println("Words sorted by frequency (most to least):");
        for (Map.Entry<String, Integer> entry : wordFrequencyList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}