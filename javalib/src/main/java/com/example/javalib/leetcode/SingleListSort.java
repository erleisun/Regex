package com.example.javalib.leetcode;

import java.util.List;

/**
 * 单链表排序
 */
public class SingleListSort {

    public static void main(String[] args) {
        ListNode sortList = sort(getListNode());

        while (sortList != null){
            System.out.println("v = " + sortList.val);
            sortList = sortList.next;
        }

    }

    private static ListNode sort(ListNode listNode){

        ListNode result = new ListNode(-1);
        ListNode pNode = result;

        return pNode;


    }

    private static ListNode getListNode() {
        ListNode listNodeOne1 = new ListNode(2);
        ListNode listNodeOne2 = new ListNode(6);
        ListNode listNodeOne3 = new ListNode(3);
        ListNode listNodeOne4 = new ListNode(5);
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
