package com.manage.gdpu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String contractNumber;
    private String contractName;
    private String signingParty;
    private String signingTime;
    private BigDecimal amount;
    // 可以根据实际合同数据在数据库表中的详细字段添加更多属性，比如合同期限、合同类型等
    public String getContractNumber() {
        return contractNumber;
    }
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }
    public String getContractName() {
        return contractName;
    }
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }
    public String getSigningParty() {
        return signingParty;
    }
    public void setSigningParty(String signingParty) {
        this.signingParty = signingParty;
    }
    public String getSigningTime() {
        return signingTime;
    }
    public void setSigningTime(Date signingTime) {
        this.signingTime = String.valueOf(signingTime);
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber='" + contractNumber + '\'' +
                ", contractName='" + contractName + '\'' +
                ", signingParty='" + signingParty + '\'' +
                ", signingTime=" + signingTime +
                ", amount=" + amount +
                '}';
    }
}
