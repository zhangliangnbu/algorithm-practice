package com.liang.algorithm.leetcode;

public class CountAndSay {
    public static void main(String[] args) {
//        System.out.println(my1(1));
//        System.out.println(my1(2));
//        System.out.println(my1(3));
//        System.out.println(my1(4));
//        System.out.println(my1(5));

        System.out.println(my2(1));
        System.out.println(my2(2));
        System.out.println(my2(3));
        System.out.println(my2(4));
        System.out.println(my2(5));

    }

    public static String my1(int n) {
        if (n <= 1) {
            return "1";
        }

        StringBuilder sb = new StringBuilder();
        String sbp = my1(n -1);
        int p = sbp.length() - 1;
        int pc = 0;
        while (p >= 0) {
            pc ++;
            if (p == 0 || sbp.charAt(p) != sbp.charAt(p - 1)) {
                sb.insert(0, sbp.charAt(p));
                sb.insert(0, pc);
                pc = 0;
            }
            p --;
        }

        return sb.toString();
    }

    public static String my2(int n) {
        if (n <= 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sbp = new StringBuilder();
        int i = 1;
        while (i <= n) {
            if (i == 1) {
                sb.insert(0, "1");
            } else {
                int p = sbp.length() - 1;
                int pc = 0;
                sb.delete(0, sb.length());
                while (p >= 0) {
                    pc ++;
                    if (p == 0 || sbp.charAt(p) != sbp.charAt(p - 1)) {
                        sb.insert(0, sbp.charAt(p));
                        sb.insert(0, pc);
                        pc = 0;
                    }
                    p --;
                }
            }
            sbp.delete(0, sbp.length());
            sbp.append(sb);
            i ++;
        }
        return sb.toString();
    }

}
