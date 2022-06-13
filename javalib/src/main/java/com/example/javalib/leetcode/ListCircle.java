package com.example.javalib.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 判断链表成环
 */
public class ListCircle {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 3, 4, 5));
//        printf(createListNode(arrayList));
        System.out.println("circle = " + listHaseCircle(createListNode(arrayList)));
    }

    /**
     * 是否回文链表  1-2-3-3-2-1
     * 一种方法可以先反转 在比较  空间时间复杂度都会增加
     * 二种方法 先将链表值复制到一个数组 在双指针判断
     * 三种方法 递归判断
     */
    private static ListNode frontList;//定义一个前指针

    private static boolean isPalindrome(ListNode listNode) {
        frontList = listNode;
        return recursionCheck(frontList);
    }

    private static boolean recursionCheck(ListNode head) {

        if(head == null){
            return true;
        }

        if (!recursionCheck(head.next)) {
            return false;
        }

        if (frontList.data == head.data) {
            frontList = frontList.next;
            return true;
        }

        return false;
    }

    /**
     * 是否有环
     *
     * @param listNode
     * @return
     */
    private static boolean listHaseCircle(ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static void printf(ListNode listNode) {
        while (listNode != null) {
            System.out.println("listNode = " + listNode.data);
            listNode = listNode.next;
        }
    }

    private static ListNode createListNode(ArrayList<Integer> arrayList) {
        ListNode listNode = new ListNode(-1);
        ListNode listNode1 = listNode;
        for (Integer integer : arrayList) {
            listNode1.next = new ListNode(integer);
            listNode1 = listNode1.next;
        }

        return listNode.next;
    }

    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int v) {
            this.data = v;
        }

        public ListNode(ListNode listNode, int v) {
            this.data = v;
            this.next = listNode;
        }
    }

}
