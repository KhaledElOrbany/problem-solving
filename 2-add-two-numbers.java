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

class LinkedListManipulation {
  ListNode create(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    ListNode head = new ListNode(nums[0]);
    ListNode curr = head;

    for (int i = 1; i < nums.length; i++) {
      curr.next = new ListNode(nums[i]);
      curr = curr.next;
    }
    return head;
  }

  void read(ListNode iter) {
    System.out.println();
    while (iter != null) {
      System.out.print(iter.val);
      iter = iter.next;
    }
    System.out.println();
  }
}

class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = null;
    ListNode currentNode = head;

    int carry = 0;
    while (l1 != null || l2 != null) {
      int l1Val = l1 != null ? l1.val : 0;
      int l2Val = l2 != null ? l2.val : 0;

      int currentSum = l1Val + l2Val + carry;
      carry = currentSum / 10;
      int lastDigit = currentSum % 10;

      if (head == null) {
        head = new ListNode(lastDigit);
        currentNode = head;
      } else {
        currentNode.next = new ListNode(lastDigit);
        currentNode = currentNode.next;
      }

      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }

    if (carry > 0) {
      currentNode.next = new ListNode(carry);
    }

    return head;
  }
}
