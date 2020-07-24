package com.liang.algorithm.leetcode;

public class AddBinary {

    public static void main(String[] args) {
        String a = "1";
        String b = "11";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int len = Math.max(a.length(), b.length());
        int ac, bc, carry = 0, current;
        for (int i = 0; i < len; i ++) {
            if (i < a.length()) {
                ac = Character.digit(a.charAt(a.length() - 1 - i), 10);
            } else {
                ac = 0;
            }
            if (i < b.length()) {
                bc = Character.digit(b.charAt(b.length() - 1 - i), 10);
            } else {
                bc = 0;
            }

            current = ac + bc + carry;
            carry = current / 2;
            current = current % 2;

            sb.insert(0, current);
        }

        if (carry == 1){
            sb.insert(0, 1);
        }

        return sb.toString();
    }
}
