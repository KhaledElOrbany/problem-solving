class ValidPalindrome {
  public boolean isPalindrome(String s) {
    if (s.isEmpty() || s.isBlank()) {
      return true;
    }
    s = s.toLowerCase().replaceAll(" ", "").replaceAll("[^A-Za-z0-9]", "");

    int left = 0, right = s.length() - 1;
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }
}
