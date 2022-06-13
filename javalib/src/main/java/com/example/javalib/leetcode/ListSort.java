package com.example.javalib.leetcode;

public class ListSort {
    public static void main(String[] args) {
//        printList(getListNodeOne());
//        printList(getListNodeTwo());
        printList(getSortListNode(getListNodeOne(), getListNodeTwo()));
    }

    /**
     * 链接两个有序链表
     *
     * @param listNode1
     * @param listNode2
     * @return
     */
    private static ListNode getSortListNode(ListNode listNode1, ListNode listNode2) {
        ListNode resultListNode = new ListNode(-1);
        ListNode pre = resultListNode;
        ListNode list1 = listNode1;
        ListNode list2 = listNode2;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;

            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;

        }

        pre.next = (list1 == null) ? list2 : list1;

        return resultListNode.next;
    }


    private static void printList(ListNode listNode) {
        ListNode t = listNode;
        while (t != null) {
            System.out.println("value = " + t.val);
            t = t.next;
        }
    }

    private static ListNode getListNodeOne() {
        ListNode listNodeOne1 = new ListNode(1);
        ListNode listNodeOne2 = new ListNode(2);
        ListNode listNodeOne3 = new ListNode(6);
        ListNode listNodeOne4 = new ListNode(8);
        ListNode listNodeOne5 = new ListNode(10);
        listNodeOne1.next = listNodeOne2;
        listNodeOne2.next = listNodeOne3;
        listNodeOne3.next = listNodeOne4;
        listNodeOne4.next = listNodeOne5;
        return listNodeOne1;
    }

    private static ListNode getListNodeTwo() {
        ListNode listNodeOne1 = new ListNode(0);
        ListNode listNodeOne2 = new ListNode(3);
        ListNode listNodeOne3 = new ListNode(5);
        ListNode listNodeOne4 = new ListNode(9);
        ListNode listNodeOne5 = new ListNode(11);
        listNodeOne1.next = listNodeOne2;
        listNodeOne2.next = listNodeOne3;
        listNodeOne3.next = listNodeOne4;
        listNodeOne4.next = listNodeOne5;
        return listNodeOne1;
    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int v) {
            this.val = v;
        }

        public ListNode(int v, ListNode node) {
            this.val = v;
            next = node;
        }
    }

}
