package com.manage.gdpu.controller;

import com.manage.gdpu.service.PurchaseService;
import com.manage.gdpu.vo.PurchaseVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    /**
     * 获取所有采购数据接口
     *
     * @return 返回包含所有采购数据的列表，若没有数据则返回空列表
     */
    @GetMapping("/api/purchase")
    public ResponseEntity<List<PurchaseVO>> getPurchaseData() {
        List<PurchaseVO> purchaseData = purchaseService.getPurchaseData();
        return ResponseEntity.ok(purchaseData);
    }

    /**
     * 根据采购单号获取特定采购数据接口
     *
     * @param purchaseNumber 采购单号
     * @return 返回特定采购的数据对象，如果不存在则返回状态码404
     */
    @GetMapping("/api/purchase/{purchaseNumber}")
    public ResponseEntity<PurchaseVO> getPurchaseByNumber(@PathVariable String purchaseNumber) {
        PurchaseVO purchase = purchaseService.getPurchaseByNumber(purchaseNumber);
        if (purchase!= null) {
            return ResponseEntity.ok(purchase);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}