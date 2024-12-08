import java.util.HashMap;

class ValidAnagram {
  // anagram
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    HashMap<Character, Integer> frequenceHashMap = new HashMap<>();
    HashMap<Character, Integer> frequenceHashMap2 = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      if (frequenceHashMap.containsKey(s.charAt(i))) {
        int count = frequenceHashMap.get(s.charAt(i));
        frequenceHashMap.put(s.charAt(i), ++count);
      } else {
        frequenceHashMap.put(s.charAt(i), 1);
      }
    }

    for (int i = 0; i < t.length(); i++) {
      if (frequenceHashMap2.containsKey(t.charAt(i))) {
        int count = frequenceHashMap2.get(t.charAt(i));
        frequenceHashMap2.put(t.charAt(i), ++count);
      } else {
        frequenceHashMap2.put(t.charAt(i), 1);
      }
    }

    return frequenceHashMap.equals(frequenceHashMap2);
  }
}
