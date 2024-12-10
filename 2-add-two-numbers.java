class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    long result = getLinkedListValue(l1) + getLinkedListValue(l2);
    return createNewLinkedList(result);
  }

  private long getLinkedListValue(ListNode l) {
    StringBuilder value = new StringBuilder();
    while (l != null) {
      value.append(l.val);
      l = l.next;
    }

    return Long.parseLong(value.reverse().toString());
  }

  private ListNode createNewLinkedList(long value) {
    char[] chars = String.valueOf(value).toCharArray();

    ListNode l = null, temp = null;
    for (int i = 0; i < chars.length; i++) {
      temp = new ListNode(chars[i] - '0');
      temp.next = l;
      l = temp;
    }

    return l;
  }
}
