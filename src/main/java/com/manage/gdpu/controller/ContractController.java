package com.manage.gdpu.controller;

import com.manage.gdpu.service.ContractService;
import com.manage.gdpu.vo.ContractVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    /**
     * 获取所有合同数据接口
     *
     * @return 返回包含所有合同数据的列表，若没有数据则返回空列表
     */
    @GetMapping("/api/contract")
    public ResponseEntity<List<ContractVO>> getContractData() {
        List<ContractVO> contractData = contractService.getContractData();
        return ResponseEntity.ok(contractData);
    }

    /**
     * 根据合同编号获取特定合同数据接口
     *
     * @param contractNumber 合同编号
     * @return 返回特定合同的数据对象，如果不存在则返回状态码404
     */
    @GetMapping("/api/contract/{contractNumber}")
    public ResponseEntity<ContractVO> getContractByNumber(@PathVariable String contractNumber) {
        ContractVO contract = contractService.getContractByNumber(contractNumber);
        if (contract!= null) {
            return ResponseEntity.ok(contract);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}