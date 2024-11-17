package com.manage.gdpu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String purchaseNumber;
    private String itemName;
    private BigDecimal purchaseAmount;
    private Date purchaseTime;
    // 可以根据实际采购数据在数据库表中的详细字段添加更多属性，比如供应商ID、采购方式等
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
        return "Purchase{" +
                "purchaseNumber='" + purchaseNumber + '\'' +
                ", itemName='" + itemName + '\'' +
                ", purchaseAmount=" + purchaseAmount +
                ", purchaseTime=" + purchaseTime +
                '}';
    }
}
