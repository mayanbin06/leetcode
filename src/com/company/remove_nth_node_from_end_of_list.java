package com.company;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class remove_nth_node_from_end_of_list {
    /**
     * 双指针一次扫描, 前后两指针相距n
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode pre = head, step = head;
        int size = 0; // 记录链表长度
        int k = 0; // 标记第一个指针走的步数
        while (step != null) {
            step = step.next;
            if (k > n) { // 距离达到 开始同时移动
                pre = pre.next;
            } else {
                k ++;
            }
            size ++;
        }
        // 当step 走到头的时候，此时pre为删除节点的上一个
        if (pre.equals(head) && n == size) { // 头节点，此时判断是删除头节点，还是头节点下一个
            return pre.next;
        }

        pre.next = pre.next.next;
        return head;
    }
    /**
     * 移除倒数第n个节点, 二次扫描
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node = head;
        // 计算链表长度
        int size = 0;
        while (node != null) {
            size ++;
            node = node.next;
        }

        int k = size - n;
        // 删除第一个节点
        if (k == 0) {
            return head.next;
        }
        // 删除后续节点
        node = head;
        while (k > 1) {
            node = node.next;
            k --;
        }
        node.next = node.next.next;
        return head;
    }
}