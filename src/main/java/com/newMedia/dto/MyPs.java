package com.newMedia.dto;

public class MyPs {
    private int soldCount;
    private int pushCount;
    private int boughtCount;
    private int sellingCount;

    public MyPs(int soldCount, int pushCount, int boughtCount, int sellingCount) {
        this.soldCount = soldCount;
        this.pushCount = pushCount;
        this.boughtCount = boughtCount;
        this.sellingCount = sellingCount;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(int sellCount) {
        this.soldCount = sellCount;
    }

    public int getPushCount() {
        return pushCount;
    }

    public void setPushCount(int pushCount) {
        this.pushCount = pushCount;
    }

    public int getBoughtCount() {
        return boughtCount;
    }

    public void setBoughtCount(int boughtCount) {
        this.boughtCount = boughtCount;
    }

    public int getSellingCount() {
        return sellingCount;
    }

    public void setSellingCount(int sellingCount) {
        this.sellingCount = sellingCount;
    }
}
