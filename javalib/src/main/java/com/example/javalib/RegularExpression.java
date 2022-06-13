package com.example.javalib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

    private static final String SOURCE = "abck鸟后ID萨阿迪 123 ，俺倒是大，电视剧哦啊到12313";

    private static final String REGEX_LETTER = "[a-zA-Z]+";
    private static final String REGEX_NUMBER = "[0-9]+";

    public static void main(String[] args) {
//        regTest1();
//        regTest2();
//        regTest3();
//        regTest4();
//        regTest5();
//        regTest6();
//        regTest7();
        regTest8();
    }


    public static void regTest8() {

        String src = "han12你好34344-你好hi han你好hellonihaohan";
        String regex = "你好(hi|hello)"; //捕获分组 group1 group2 为空
//        String regex = "你好(?:hi|hello)"; //非捕获分组 group1 group2 为空
//        String regex = "你好(?=hi|hello)"; //非捕获分组 group1 group2 为空
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(src);
        //取出匹配的结果
        while (matcher.find()) {
            //找出所有匹配的字串
            System.out.println("find:" + matcher.group(0));
        }
    }

    public static void regTest7() {

        String src = "1234344-aahan hannihaohan";
        String regex = "(\\d\\d)(\\d{2})";//捕获分组
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(src);
        //取出匹配的结果
        while (matcher.find()) {
            //找出所有匹配的字串
            System.out.println("find:" + matcher.group(0) + " group(1) = " + matcher.group(1));
        }
    }

    /**
     * 限定符
     */
    public static void regTest6() {
//        String src = "1234aa1111234abvccc";
//        String src = "1234-aa";

//        String regex = "^[0-9]+[a-z]*";//至少一个数字开头，后接任意个小写字母的自串

//        String regex = "^[0-9]+[a-z]+$";//至少一个数字开头，至少一个小写字母结尾
//        String regex = "^[0-9]+\\-[a-z]+$";//至少一个数字开头，至少一个小写字母结尾 同时中间一个-

        String src = "1234-aahan hannihaohan";
//        String regex = "han\\b";//最后是一个han  或者空格前是一个han
        String regex = "han\\B";//最后是一个han  或者空格前是一个han

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(src);
        //取出匹配的结果
        while (matcher.find()) {
            //找出所有匹配的字串
            System.out.println("find:" + matcher.group(0));
        }
    }

    /**
     * 限定符
     */
    public static void regTest5() {
        String src = "aa111111aaaaaaaa34aaabd%jadjajdahello12143ada";
//        String regex = "1{4}"; //匹配四个1 后面两个1不够了 不匹配
//        String regex = "a{3}"; //匹配3个a
//        String regex = "\\d{3}"; //匹配一个三位数  任意三个数字

//        String regex = "a{3,4}"; //匹配三个a 或者4个a  优先贪婪匹配 匹配4个
//        String regex = "\\d{2,5}"; //匹配二三四五个数字 优先大的数

//        String regex = "1+"; //匹配1个1 或者多个1
//        String regex = "\\d+"; //匹配1个数字 或者多个数字

//        String regex = "a*"; //匹配0个a或者1个a 或者多个a
//        String regex = "a1*"; //匹配1个a或者0个1或者1个a一个1 或者1个a多个1

//        String regex = "a?"; //匹配0个a 或者1个a
        String regex = "aa1?"; //匹配1个a 或者1个a0个1 或者一个a 1个1


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(src);
        //取出匹配的结果
        while (matcher.find()) {
            //找出所有匹配的字串
            System.out.println("find:" + matcher.group(0));
        }
    }

    /**
     * 选择符
     */
    public static void regTest4() {
        String src = "abc(ABCd@defe12345_!@#$%^&*()— aada你好大家好";
//        String regex = "ab|cd"; //匹配ab或者cd
//        String regex = "(?i)ab|cd"; //ab忽略大小写或者cd
        String regex = "(?i)(ab|cd|好)"; //匹配ab或者cd都忽略大小写
        //创建正则表达式对象
        Pattern pattern = Pattern.compile(regex);
        //创建一个匹配器 按照正则表达式匹配 source 字串
        Matcher matcher = pattern.matcher(src);
        //取出匹配的结果
        while (matcher.find()) {
            //找出所有匹配的字串
            System.out.println("find:" + matcher.group(0));
        }
    }

    //匹配符
    public static void regTest3() {

        String src = "abc(ABC@defe12345_!@#$%^&*()— aada";
//        String regex = "abc"; //只匹配abc
//        String regex = "(?i)abc"; //不区分abc的大小写
//        String regex = "a(?i)bc"; //不区分bc的大小写
//        String regex = "a((?i)b)c"; //只有b不区分大小写
//        String regex = "[^a-z]"; //匹配非a-z任意的字符
//        String regex = "\\d";//匹配任意数字
//        String regex = "\\D";//匹配任意非数字
//        String regex = "\\w"; //匹配大小写字母 数字 下划线 相当于 [0-9a-zA-Z]
//        String regex = "\\W"; //匹配非大小写字母 数字 下划线 相当于 [0-9a-zA-Z]
//        String regex = "\\s"; //匹配空格
//        String regex = "\\S"; //匹配非空格
        String regex = "."; //匹配除\n之外所有字符
        //创建正则表达式对象
        Pattern pattern = Pattern.compile(regex);
        //创建一个匹配器 按照正则表达式匹配 source 字串
        Matcher matcher = pattern.matcher(src);
        //取出匹配的结果
        while (matcher.find()) {
            //找出所有匹配的字串
            System.out.println("find:" + matcher.group(0));
        }
    }

    public static void regTest2() {

        String src = "abc(cdd(";
        String regex = "\\(";
        //创建正则表达式对象
        Pattern pattern = Pattern.compile(regex);
        //创建一个匹配器 按照正则表达式匹配 source 字串
        Matcher matcher = pattern.matcher(src);
        //取出匹配的结果
        while (matcher.find()) {
            //找出所有匹配的字串
            System.out.println("find:" + matcher.group(0));
        }
    }

    public static void regTest1() {
        //创建正则表达式对象
        Pattern pattern = Pattern.compile(REGEX_NUMBER);
        //创建一个匹配器 按照正则表达式匹配 source 字串
        Matcher matcher = pattern.matcher(SOURCE);
        //取出匹配的结果
        while (matcher.find()) {
            //找出所有匹配的字串
            System.out.println("find:" + matcher.group(0));
        }

        //匹配是否符合正则表达式
        boolean isMatch = Pattern.matches(REGEX_LETTER, SOURCE);
        System.out.println("isMatch:" + isMatch);
    }

}
