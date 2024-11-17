package com.manage.gdpu.vo;

import java.math.BigDecimal;

public class ContractVO {
    private String contractNumber;
    private String contractName;
    private String signingParty;
    private String signingTime;
    private BigDecimal amount;

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

    public void setSigningTime(String signingTime) {
        this.signingTime = signingTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ContractVO{" +
                "contractNumber='" + contractNumber + '\'' +
                ", contractName='" + contractName + '\'' +
                ", signingParty='" + signingParty + '\'' +
                ", signingTime='" + signingTime + '\'' +
                ", amount=" + amount +
                '}';
    }
}