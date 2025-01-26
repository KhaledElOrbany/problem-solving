import java.util.HashSet;

class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    HashSet<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }

    int theLongest = 0;
    for (int num : numSet) {
      if (!numSet.contains(num - 1)) {
        int currentNumber = num;
        int currentLongest = 1;

        while (numSet.contains(currentNumber + 1)) {
          currentNumber++;
          currentLongest++;
        }

        theLongest = Math.max(theLongest, currentLongest);
      }
    }

    return theLongest;
  }
}
