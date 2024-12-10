class ValidParentheses {
  public boolean isValid(String s) {
    if (s.length() % 2 == 1) {
      return false;
    }

    StringBuilder stack = new StringBuilder();
    for (char ch : s.toCharArray()) {
      if (ch == '(' || ch == '[' || ch == '{') {
        stack.append(ch);
      } else if (ch == ')' && (stack.isEmpty() || stack.charAt(stack.length() - 1) != '(')) {
        return false;
      } else if (ch == '}' && (stack.isEmpty() || stack.charAt(stack.length() - 1) != '{')) {
        return false;
      } else if (ch == ']' && (stack.isEmpty() || stack.charAt(stack.length() - 1) != '[')) {
        return false;
      } else {
        stack.deleteCharAt(stack.length() - 1);
      }
    }

    return stack.length() == 0;
  }
}
