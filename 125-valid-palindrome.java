class ValidPalindrome {
  public boolean isPalindrome(String s) {
    if (s.isEmpty() || s.isBlank()) {
      return true;
    }

    s = s.toLowerCase().replaceAll(" ", "").replaceAll("[^A-Za-z0-9]", "");

    StringBuilder t = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      t.append(s.charAt(i));
    }

    return s.equals(t.toString());
  }
}
