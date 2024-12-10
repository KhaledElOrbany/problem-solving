import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
  // "eat", "tea", "tan", "ate", "nat", "bat"
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> str2ascii = new HashMap<>();

    for (String str : strs) {
      String ascii = getStrAscii(str);

      if (str2ascii.containsKey(ascii)) {
        str2ascii.get(ascii).add(str);
      } else {
        List<String> newList = new ArrayList<>();
        newList.add(str);
        str2ascii.put(ascii, newList);
      }
    }

    return new ArrayList<>(str2ascii.values());
  }

  private String getStrAscii(String str) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    StringBuilder ascii = new StringBuilder();
    for (char ch : chars) {
      ascii.append((int) ch);
    }
    return ascii.toString();
  }
}
