package com.company;

public class add_two_numbers {

    public static void test() {
        //ListNode l1 = new ListNode(2,
        //        new ListNode(4,
        //                new ListNode(3)));
        //ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        ListNode result = new add_two_numbers().addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode first = l1, second = l2;
        ListNode result = null, p = null;
        int j = 0; // 进位
        while (first != null && second != null) {
            int a = first.val + second.val + j;
            j = a / 10;
            ListNode n = new ListNode(a % 10);
            if (result == null) {
                result = p = n;
            } else {
                p.next = n;
                p = n;
            }

            first = first.next;
            second = second.next;
        }
        // 剩余的
        ListNode r = first != null ? first : second != null ? second : null;
        while (r != null) {
            int a = r.val + j;
            j = a / 10;
            ListNode n = new ListNode(a % 10);
            p.next = n;
            p = n;

            r = r.next;
        }

        if (j > 0) { // 最后的进位
           p.next = new ListNode(j);
        }
        return result;
    }
}
