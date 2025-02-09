import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TopKFrequentElements {
  // nums: [1, 1, 1, 2, 2, 3]
  // k: 2
  // output: [1,2]
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : nums) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    List<Integer>[] bucket = new List[nums.length + 1];
    for (int key : frequencyMap.keySet()) {
      int frequency = frequencyMap.get(key);
      if (bucket[frequency] == null) {
        bucket[frequency] = new ArrayList<>();
      }
      bucket[frequency].add(key);
    }

    List<Integer> topK = new ArrayList<>();
    for (int i = bucket.length - 1; i >= 0 && topK.size() < k; i--) {
      if (bucket[i] != null) {
        topK.addAll(bucket[i]);
      }
    }

    return topK.stream().mapToInt(i -> i).toArray();
  }
}
