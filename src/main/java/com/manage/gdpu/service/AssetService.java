package com.manage.gdpu.service;

import com.manage.gdpu.entity.Asset;
import com.manage.gdpu.repository.AssetRepository;
import com.manage.gdpu.vo.AssetVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssetService {

    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    /**
     * 获取所有资产数据的方法，添加将实体类转换为VO类的逻辑
     *
     * @return 返回包含所有资产数据的VO列表，若数据库中无数据则返回空列表
     */
    public List<AssetVO> getAssetData() {
        List<Asset> assetList = assetRepository.findAll();
        List<AssetVO> assetVOList = new ArrayList<>();
        for (Asset asset : assetList) {
            AssetVO assetVO = new AssetVO();
            // 将实体类的属性值复制到VO类对应的属性中
            assetVO.setAssetNumber(asset.getAssetNumber());
            assetVO.setAssetName(asset.getAssetName());
            assetVO.setAssetType(asset.getAssetType());
            assetVO.setPurchaseTime(asset.getPurchaseTime());
            assetVO.setStatus(asset.getStatus());
            // 可以根据实际情况补充更多属性的赋值

            assetVOList.add(assetVO);
        }
        return assetVOList;
    }

    // 其他方法（如根据资产编号获取特定资产数据等）保持不变或按需同样进行类似的类型转换处理

    /**
     * 根据资产编号获取特定资产数据的方法
     *
     * @param assetNumber 资产编号
     * @return 返回特定的资产数据的VO对象，如果不存在则返回null
     */
    public AssetVO getAssetByNumber(String assetNumber) {
        Asset asset = assetRepository.findByAssetNumber(assetNumber);
        if (asset!= null) {
            AssetVO assetVO = new AssetVO();
            assetVO.setAssetNumber(asset.getAssetNumber());
            assetVO.setAssetName(asset.getAssetName());
            assetVO.setAssetType(asset.getAssetType());
            assetVO.setPurchaseTime(asset.getPurchaseTime());
            assetVO.setStatus(asset.getStatus());
            // 同样按需补充更多属性赋值
            return assetVO;
        }
        return null;
    }
}