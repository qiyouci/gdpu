package com.manage.gdpu.vo;

import java.math.BigDecimal;
import java.util.Date;

public class PurchaseVO {
    private String purchaseNumber;
    private String itemName;
    private BigDecimal purchaseAmount;
    private Date purchaseTime;

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    @Override
    public String toString() {
        return "PurchaseVO{" +
                "purchaseNumber='" + purchaseNumber + '\'' +
                ", itemName='" + itemName + '\'' +
                ", purchaseAmount=" + purchaseAmount +
                ", purchaseTime='" + purchaseTime + '\'' +
                '}';
    }
}