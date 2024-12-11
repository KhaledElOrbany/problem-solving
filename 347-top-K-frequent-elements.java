import java.util.HashMap;

class TopKFrequentElements {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> num2freq = new HashMap<>();
    for (int num : nums) {
      num2freq.put(num, num2freq.getOrDefault(num, 0) + 1);
    }

    return null;
  }
}
