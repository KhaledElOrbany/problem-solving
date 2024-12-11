import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TopKFrequentElements {
  // 1,1,1,2,2,3 - 2
  public int[] topKFrequent(int[] nums, int k) {
    // Step 1: Count frequencies
    HashMap<Integer, Integer> num2freq = new HashMap<>();
    for (int num : nums) {
      num2freq.put(num, num2freq.getOrDefault(num, 0) + 1);
    }

    // Step 2: Create a frequency bucket array
    // The maximum frequency any number can have is nums.length
    List<Integer>[] freqBuckets = new List[nums.length + 1];
    for (int i = 0; i < freqBuckets.length; i++) {
      freqBuckets[i] = new ArrayList<>();
    }

    // Group numbers by frequency
    for (Map.Entry<Integer, Integer> entry : num2freq.entrySet()) {
      int num = entry.getKey();
      int freq = entry.getValue();
      freqBuckets[freq].add(num);
    }

    // Step 3: Collect top k frequent elements
    int[] result = new int[k];
    int count = 0;

    // Traverse from highest frequency to lowest
    for (int i = freqBuckets.length - 1; i >= 0 && count < k; i--) {
      for (int num : freqBuckets[i]) {
        result[count++] = num;
        if (count == k) {
          break;
        }
      }
    }

    return result;
  }
}
