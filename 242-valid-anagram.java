import java.util.Arrays;

class ValidAnagram {
  // anagram
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    return sortedString(s).equals(sortedString(t));
  }

  private String sortedString(String str) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
}
