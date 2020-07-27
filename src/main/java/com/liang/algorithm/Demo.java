package com.liang.algorithm;

/**
 * @author : zhangliang
 * @date : 2020/6/11
 */
public class Demo {

    private static final int REGION_LEFT = 0x01;
    private static final int REGION_RIGHT = 0x02;
    private static final int REGION_HORIZONTAL_MASK = 0x03;
    private static final int REGION_TOP = 0x10;
    private static final int REGION_BOTTOM = 0x20;
    private static final int REGION_VERTICAL_MASK = 0x30;


    public static void main(String[] args) {
        calByte();
    }

    /// 二进制计算
    public static void calByte() {
        int touchRegion = REGION_LEFT | REGION_TOP;
        System.out.println(touchRegion);
        System.out.println(touchRegion & REGION_HORIZONTAL_MASK);
        System.out.println(touchRegion & REGION_VERTICAL_MASK);

        touchRegion = REGION_LEFT | REGION_BOTTOM;
        System.out.println(touchRegion);
        System.out.println(touchRegion & REGION_HORIZONTAL_MASK);
        System.out.println(touchRegion & REGION_VERTICAL_MASK);
    }

}
