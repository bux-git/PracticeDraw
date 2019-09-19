package com.hencoder.hencoderpracticedraw1;

/**
 * description：
 * author：bux on 2019/9/19 9:52
 * email: 471025316@qq.com
 */
public class RectBean {
    private String name;
    private int value;
    private int color;
    public static int totalCount;

    public RectBean(String name, int value) {
        this.name = name;
        this.value = value;
        totalCount += value;
    }

    public RectBean(String name, int value, int color) {
        this.name = name;
        this.value = value;
        this.color = color;
        totalCount += value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    public static void setTotalCount(int totalCount) {
        RectBean.totalCount = totalCount;
    }
}
