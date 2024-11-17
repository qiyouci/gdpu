package com.manage.gdpu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String assetNumber;
    private String assetName;
    private String assetType;
    private String purchaseTime;
    private String status;
    // 可以根据实际资产数据在数据库表中的更多字段添加属性，比如使用部门ID、存放地点等
    public String getAssetNumber() {
        return assetNumber;
    }
    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }
    public String getAssetName() {
        return assetName;
    }
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
    public String getAssetType() {
        return assetType;
    }
    public void setAssetType(String assetType) { this.assetType = assetType; }
    public String getPurchaseTime() {
        return purchaseTime;
    }
    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = String.valueOf(purchaseTime);
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Asset{" +
                "assetNumber='" + assetNumber + '\'' +
                ", assetName='" + assetName + '\'' +
                ", assetType='" + assetType + '\'' +
                ", purchaseTime=" + purchaseTime +
                ", status='" + status + '\'' +
                '}';
    }
}
