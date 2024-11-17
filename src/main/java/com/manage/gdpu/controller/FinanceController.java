package com.manage.gdpu.controller;
import com.manage.gdpu.service.FinanceService;
import com.manage.gdpu.vo.FinanceDataVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class FinanceController {

    private final FinanceService financeService;

    public FinanceController(FinanceService financeService) {
        this.financeService = financeService;
    }

    /**
     * 获取财务数据接口
     *
     * @return 返回包含财务数据的列表，若没有数据则返回空列表
     */
    @GetMapping("/api/finance")
    public ResponseEntity<List<FinanceDataVO>> getFinanceData() {
        List<FinanceDataVO> financeData = financeService.getFinanceData();
        return ResponseEntity.ok(financeData);
    }
}