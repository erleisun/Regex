package com.example.javalib.leetcode;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 三种解法
 * 1.先将数组二拷贝到数组1  在排序
 * 2.先将数组1 拷贝一份 在逐个比较数组一和2 按顺序拷贝进去
 * 3.从后往前 双指针法
 */
public class MergerArray {

    public static void main(String[] args) {

        int[] num1 = new int[]{2, 5, 7, 0, 0, 0, 0};
        int[] num2 = new int[]{1, 3, 6, 8};
//        mergerArr(num1, num2, 3, 3);

//        merger1(num1, num2, 3, num2.length);
//        merger2(num1, num2, 3, num2.length);
        merger3(num1, num2, 3, num2.length);
    }

    /**
     * 拷贝后 在排序法
     */
    public static void merger1(int[] num1, int[] num2, int m, int n) {
        //将数组2 从第0位开始  拷贝到数组1中 从m位置存放 n长度
        System.arraycopy(num2, 0, num1, m, n);
        Arrays.sort(num1);

        for (int j : num1) {
            System.out.println("num1 = " + j);
        }
    }

    /**
     * 拷贝数组1 在填充
     */
    public static void merger2(int[] num1, int[] num2, int m, int n) {
        //将数组2 从第0位开始  拷贝到数组1中 从m位置存放 n长度
        int[] temNum = new int[m + n];
        //复制一份数组1
        System.arraycopy(num1, 0, temNum, 0, m);

        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (p1 == m) {
                num1[i] = num2[p2++];
            } else if (p2 == n) {
                num1[i] = temNum[p1++];
            } else if (temNum[p1] <= num2[p2]) {
                num1[i] = temNum[p1];
                p1++;
            } else {
                num1[i] = num2[p2];
                p2++;
            }
        }

        for (int j : num1) {
            System.out.println("num1 = " + j);
        }
    }

    /**
     * 从后往前双指针
     */
    public static void merger3(int[] num1, int[] num2, int m, int n) {

        int p1 = m - 1, p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0 || p2 >= 0)) {

            if(p1 == -1){
                num1[p--] = num2[p2--];
            }else if(p2 == -1){
                num1[p--] = num1[p1--];
            }else if((num1[p1] > num2[p2])){
                num1[p--] = num1[p1--];
            }else{
                num1[p--] = num2[p2--];
            }
        }

        for (int j : num1) {
            System.out.println("num1 = " + j);
        }
    }
}
