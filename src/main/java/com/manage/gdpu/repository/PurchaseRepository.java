package com.manage.gdpu.repository;

import com.manage.gdpu.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {

    @Query("SELECT p FROM Purchase p WHERE p.purchaseNumber =?1")
    Purchase findByPurchaseNumber(String purchaseNumber);
}