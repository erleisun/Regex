package com.example.javalib;

public class MyClass1 {

    public static void main(String[] args) {

        int input = 3;
        //输出自己 第一种结果
        System.out.println(input + "=" + input);
        //记录有几种结果
        int index = 1;
        //最大一半
        int endIndex = (input/2 + 1);
        while(endIndex > 0){
            for(int j=endIndex-1; j>=1; j--){
                if(getSum(endIndex,j) == input){
                    printlnResult(input,j,endIndex);
                    index++;
                    break;
                }
            }
            endIndex--;
        }
        System.out.println("Result:" + index);
    }
    /**
     n 最大的连续树
     m 最小的连续树
     */
    private static int getSum(int n,int m){
        if(n == 0 || n == 1){
            return n;
        }

        //取得最小数
        if(n == m){
            return m;
        }
        return n+getSum(n-1,m);
    }

    /**
     输出一行等式
     */
    private static void printlnResult(int input,int start,int end){
        System.out.println("start = " + start + " end = " + end + " input = " + input);
        StringBuilder builder = new StringBuilder();
        builder.append(input).append("=");
        for(int i = start;i<=end;i++){
            builder.append(i);
            if(i != end){
                builder.append("+");
            }
        }
        System.out.println(builder.toString());
    }



}
