import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TopKFrequentElements {
  // nums: [1, 1, 1, 2, 2, 3]
  // k: 2
  // output: [1,2]
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> num2freq = new HashMap<>();
    for (int num : nums) {
      num2freq.put(num, num2freq.getOrDefault(num, 0) + 1);
    }

    List<Integer>[] freqBuckets = new List[nums.length + 1];
    for (int i = 0; i < freqBuckets.length; i++) {
      freqBuckets[i] = new ArrayList<>();
    }

    for (Map.Entry<Integer, Integer> entry : num2freq.entrySet()) {
      freqBuckets[entry.getValue()].add(entry.getKey());
    }

    int[] result = new int[k];
    int count = 0;

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
