package com.manage.gdpu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String financeName;
    private BigDecimal amount;
    private String description;
    // 可以根据实际财务数据在数据库表中的字段情况添加更多属性，比如所属项目ID、财务时间等
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFinanceName() {
        return financeName;
    }
    public void setFinanceName(String financeName) {
        this.financeName = financeName;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Finance{" +
                "id=" + id +
                ", financeName='" + financeName + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}