package com.example.javalib;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionExample {

    public static void main(String[] args) {
//        regTest();
//        regTest1();
//        regTest2();
//        regTest4();
//        regTest6();
//        regTest7();
//        regTest8();
//        regTest9();
//        regTest10();
//        regexTest();
        regTest121();
    }

    public static void regTest121() {
        //校验手机号
        String phoneNumber = "13012345667";
        boolean ret = phoneNumber.matches("1(38|39)\\d{8}");
        System.out.println("ret = " + ret);

        //替换文本
        String src = "JDK是 Java 语言的软件开发工具包，主要用于移动设备、嵌入式设备上的java应用程序";
        String newContent = src.replaceAll("JDK|java|Java", "HELLO WORD");
        System.out.println("new content = " + newContent);

        //分割字符串
        String content = "hello%my#name#is*tom";
        String[] split = content.split("%|#|\\*|-");
        System.out.println(Arrays.asList(split));

    }


    //字串分割
    public static void regTest10() {
        String src = "hello%my#name#is*tom";
//        String[] split = src.split("[%#*-]");
        String[] split = src.split("%|#|\\*|-");
        System.out.println(Arrays.asList(split));
    }

    //判断手机号是否已138 139开头
    public static void regTest9() {
        String phoneNumber = "13012345667";
        boolean ret = phoneNumber.matches("1(38|39)\\d{8}");
        System.out.println("ret = " + ret);
    }

    //使用String方法中的正则表达式替换场景
    public static void regTest8() {
        String src = "JDK是 Java 语言的软件开发工具包，主要用于移动设备、嵌入式设备上的java应用程序。" +
                "JDK是整个java开发的核心，它包含了JAVA的运行环境（JVM+Java系统类库）和JAVA工具。";
        String newContent = src.replaceAll("JDK|java|Java", "我是大魔王");
        System.out.println("new content = " + newContent);
    }


    //分组匹配 几个()就是几个组
    //对一个url进行解析 https://www.baidu.com:8080/abc/index.html
    //1.http/https ^(https?)  ^([a-zA-Z]+)
    //2.www.baidu.com  ([a-zA-Z.]+)
    //3.8080
    //文件名 .html
    public static void regTest7() {
        String src = "http://www.baidu.com:8080/@#abc/ind!@ex.html";
//        String regex = "^(https?)://(([\\w]+\\.)+[\\w]+)*(:[\\d]+)?(/[\\w]+/?)*(\\.[\\w]+)";
        String regex = "^([a-zA-Z]+)://([a-zA-Z.]+)+:?(\\d+)?[/\\w!@#$%]+?/([\\w!@#$%]+\\.[a-zA-Z]+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(src);
        //取出匹配的结果
        while (matcher.find()) {
            //找出所有匹配的字串
            System.out.println("find:" + matcher.group(0));
            System.out.println("find protocol:" + matcher.group(1));
            System.out.println("find domin:" + matcher.group(2));
            System.out.println("find port:" + matcher.group(3));
            System.out.println("find port:" + matcher.group(4));
        }
    }

    //验证是不是整数或者小数
    //1.要考虑整数和负数
    //2. 比如 123 -345 34.89  -0.02 0.45   0023.3 -0.02
    public static void regTest6() {
        String src = "01.11";
        String regex = "^[-]?([1-9]\\d*|0)(\\.?\\d+)?$";  //整数位只有1位数的时候 需要|0

        System.out.println("result = " + Pattern.matches(regex, src));

//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(src);
//        //取出匹配的结果
//        while (matcher.find()) {
//            //找出所有匹配的字串
//            System.out.println("find:" + matcher.group(0));
//        }
    }

    //验证邮箱格式
    //1.只能有一个@
    //2.@前面是用户名 可以是a-z A-Z 0-9 下划线  ([a-zA-Z0-9_]+) 或者 [\\w]+
    //3.@后面 只能是域名 并且域名只能是英文字母 比如sohu.com  baidu.com.cn  ([a-zA-Z]+\.)+[a-zA-Z]+
    public static void regTest5() {
        String src = "qeeee@qq.com.cn";
        String regex = "^([a-zA-Z0-9_]+)@([a-zA-Z]+\\.)+[a-zA-Z]+$";

        System.out.println("result = " + Pattern.matches(regex, src));

//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(src);
//        //取出匹配的结果
//        while (matcher.find()) {
//            //找出所有匹配的字串
//            System.out.println("find:" + matcher.group(0));
//        }
    }

    //匹配URL
    public static void regTest4() {
//        String src = "https://codejiaonang.com/#/course/regex_chapter1/0/0";
//        String src = "https://codejiaonang.com";
        String src = "https://www.bilibili.com/video/BV1Eq4y1E79W?p=17&vd_source=2af9912c0df4034780cf0a502918488d";

        // 1.开头为http://或者https://  ^((http|https)://)  ^((https?)://)   ?表示最多出现一次或者0次
        // 2.第二部分 www.xxx.com  也可能是xxx.xxx  xxx.xxx.xxx  xxx. 至少有一个xxx.
        // + 表示至少重复一次或者n次 ([\w]+\.)+[\w]+
        //3.参数部分 /course/regex_chapter1   \如果是真斜线 需要用\\转义
        // ? 写在中括号里面 就是一个问号 不是限定符 * 表示可以重复0次或者n次
        String regex = "^((http|https)://)?([\\w]+\\.)+[\\w]+(\\/[\\w-#?=_%.&/]*)?$";
//        String regex = "^((https?)://)";

//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(src);

        System.out.println("result = " + Pattern.matches(regex, src));
        //取出匹配的结果
//        while (matcher.find()) {
//            找出所有匹配的字串
//            System.out.println("find:" + matcher.group(0));
//        }
    }


    //验证手机号码  必须以13 15 18 14 开头的11位数
    public static void regTest3() {
        String src = "13971491111";
//        String regex = "^[1-9]\\d{4,9}$";  //开头1到9  后面四到9位数
//        String regex = "^(13|15|18|14)\\d{9}$";
        String regex = "^1(3|5|8|4)\\d{9}$";
//        String regex = "^[13|15|14|18]\\d{9}$"; //xxxxxxxxx
//        String regex = "^1[3|5|8|4]\\d{9}$";  //开头1到9  后面四到9位数
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(src);
        //取出匹配的结果
        while (matcher.find()) {
            //找出所有匹配的字串
            System.out.println("find:" + matcher.group(0));
        }
    }


    //验证qq号码  格式要求： 1-9开头的 5到10位的数字 比如19800  19999999
    public static void regTest2() {
        String src = "1997149111";
        String regex = "^[1-9]\\d{4,9}$";  //开头1到9  后面四到9位数
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(src);
        //取出匹配的结果
        while (matcher.find()) {
            //找出所有匹配的字串
            System.out.println("find:" + matcher.group(0));
        }
    }

    //验证邮政编码  格式要求 1-9开头 组成的6位数
    public static void regTest1() {

        String src = "223400";
        String regex = "^[1-9]\\d{5}$";  //开头1到9 结尾 5个数字
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(src);
        //取出匹配的结果
        while (matcher.find()) {
            //找出所有匹配的字串
            System.out.println("find:" + matcher.group(0));
        }

    }

    //输入的是否是全汉字
    public static void regTest() {

//        String src = "他han12你好34344-你好hi han你好hellonihaohan好";
        String src = "爱搭搭所，1,";
        String regex = "[\u0391-\uffe5]";//只匹配一个汉字 包含中文的标点符号等
//        String regex = "[\u4e00-\u9fa5]+";//匹配多个汉字 纯汉字 不包含标点

//        String regex = "^[\u4e00-\u9fa5]+$"; //首位都是汉字
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(src);
        //取出匹配的结果
        while (matcher.find()) {
            //找出所有匹配的字串
            System.out.println("find:" + matcher.group(0));
        }

    }


    public static void regexTest() {
        String context = "正则表达式(Regular Expression)是一种文本模式，" +
                "包括普通字符（例如，a 到 z 之间的字母）和特殊字符（称为\"元字符\"）。";
        //匹配纯汉字,不包含中文标点
        String regex = "[\u4e00-\u9fa5]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(context);
        //取出匹配的结果
        while (matcher.find()) {
            //找出所有匹配的字串
            System.out.println("result:" + matcher.group(0));
        }
    }


    //验证邮箱格式
    //1.只能有一个@
    //2.@前面是用户名 可以是a-z A-Z 0-9 下划线  ([a-zA-Z0-9_]+) 或者 [\\w]+
    //3.@后面 只能是域名 并且域名只能是英文字母 比如sohu.com  baidu.com.cn  ([a-zA-Z]+\.)+[a-zA-Z]+
    public static void regTest55() {
        String src = "qeeee@qq.com.cn";
        String regex = "^([a-zA-Z0-9_]+)@([a-zA-Z]+\\.)+[a-zA-Z]+$";

        boolean result = Pattern.matches(regex, src);
        System.out.println("result = " + result);
    }


}
