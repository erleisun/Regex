package com.example.javalib.leetcode;

import java.sql.ClientInfoStatus;

/**
 * 链表反转
 */
public class ReverseList {

    public static void main(String[] args) {

        ListNode listNode3 = new ListNode(new ListNode(new ListNode(3),2), 1);
//        while (listNode3 != null){
//            System.out.println(listNode3.data);
//            listNode3 = listNode3.next;
//        }

//        ListNode listNode = reverseNode(listNode3);

        ListNode listNode = recursionReverse(listNode3);
        while (listNode != null){
            System.out.println(listNode.data);
            listNode = listNode.next;
        }

    }

    public static ListNode reverseNode(ListNode listNode) {

        ListNode pre = null;
        while (listNode != null) {
            ListNode temp = listNode.next;//保存下一个节点
            listNode.next = pre;//当前节点指向新的节点
            pre = listNode;//将pre指针指向新节点
            listNode = temp;//listNode赋值为下一个节点
        }
        return pre;
    }


    static ListNode listNode1 = new ListNode(-1);
    static ListNode listNode2 = listNode1;
    /**
     * 递归方法 反转列表
     * @param listNode
     * @return
     */
    public static ListNode recursionReverse(ListNode listNode){
        recursion(listNode);
        return listNode1;
    }

    public static void recursion(ListNode head){

        if(head != null){
            recursion(head.next);
            listNode2.next = head;
            System.out.println("listNode2.value = " + listNode2.data);
            listNode2 = listNode2.next;
            System.out.println("listNode2after.value = " + listNode2.data);
        }
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
