package com.manage.gdpu.repository;

import com.manage.gdpu.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractRepository extends JpaRepository<Contract, String> {

    @Query("SELECT c FROM Contract c WHERE c.contractNumber =?1")
    Contract findByContractNumber(String contractNumber);
}