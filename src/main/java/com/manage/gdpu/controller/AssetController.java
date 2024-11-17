package com.manage.gdpu.controller;

import com.manage.gdpu.service.AssetService;
import com.manage.gdpu.vo.AssetVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    /**
     * 获取所有资产数据接口
     *
     * @return 返回包含所有资产数据的列表，若没有数据则返回空列表
     */
    @GetMapping("/api/asset")
    public ResponseEntity<List<AssetVO>> getAssetData() {
        List<AssetVO> assetData = assetService.getAssetData();
        return ResponseEntity.ok(assetData);
    }

    /**
     * 根据资产编号获取特定资产数据接口
     *
     * @param assetNumber 资产编号
     * @return 返回特定资产的数据对象，如果不存在则返回状态码404
     */
    @GetMapping("/api/asset/{assetNumber}")
    public ResponseEntity<AssetVO> getAssetByNumber(@PathVariable String assetNumber) {
        AssetVO asset = assetService.getAssetByNumber(assetNumber);
        if (asset!= null) {
            return ResponseEntity.ok(asset);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}