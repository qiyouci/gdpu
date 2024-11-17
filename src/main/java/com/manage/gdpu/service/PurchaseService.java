package com.manage.gdpu.service;

import com.manage.gdpu.entity.Purchase;
import com.manage.gdpu.repository.PurchaseRepository;
import com.manage.gdpu.vo.PurchaseVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    /**
     * 获取所有采购数据的方法，添加将实体类转换为VO类的逻辑
     *
     * @return 返回包含所有采购数据的VO列表，若数据库中无数据则返回空列表
     */
    public List<PurchaseVO> getPurchaseData() {
        List<Purchase> purchaseList = purchaseRepository.findAll();
        List<PurchaseVO> purchaseVOList = new ArrayList<>();
        for (Purchase purchase : purchaseList) {
            PurchaseVO purchaseVO = new PurchaseVO();
            // 将实体类的属性值复制到VO类对应的属性中
            purchaseVO.setPurchaseNumber(purchase.getPurchaseNumber());
            purchaseVO.setItemName(purchase.getItemName());
            purchaseVO.setPurchaseAmount(purchase.getPurchaseAmount());
            purchaseVO.setPurchaseTime(purchase.getPurchaseTime());
            // 可以根据实际情况补充更多属性的赋值，比如供应商、采购方式等信息

            purchaseVOList.add(purchaseVO);
        }
        return purchaseVOList;
    }

    /**
     * 根据采购单号获取特定采购数据的方法，进行类型转换
     *
     * @param purchaseNumber 采购单号
     * @return 返回特定的采购数据的VO对象，如果不存在则返回null
     */
    public PurchaseVO getPurchaseByNumber(String purchaseNumber) {
        Purchase purchase = purchaseRepository.findByPurchaseNumber(purchaseNumber);
        if (purchase!= null) {
            PurchaseVO purchaseVO = new PurchaseVO();
            purchaseVO.setPurchaseNumber(purchase.getPurchaseNumber());
            purchaseVO.setItemName(purchase.getItemName());
            purchaseVO.setPurchaseAmount(purchase.getPurchaseAmount());
            purchaseVO.setPurchaseTime(purchase.getPurchaseTime());
            // 按需补充更多属性赋值
            return purchaseVO;
        }
        return null;
    }

    /**
     * 保存采购数据（新增或更新采购）的方法，处理VO和实体类之间的转换
     *
     * @param purchaseVO 要保存的采购数据的VO对象
     * @return 保存后的采购数据的VO对象
     */
    public PurchaseVO savePurchase(PurchaseVO purchaseVO) {
        Purchase purchase = new Purchase();
        purchase.setPurchaseNumber(purchaseVO.getPurchaseNumber());
        purchase.setItemName(purchaseVO.getItemName());
        purchase.setPurchaseAmount(purchaseVO.getPurchaseAmount());
        purchase.setPurchaseTime(purchaseVO.getPurchaseTime());
        // 处理其他相关属性赋值，将VO属性复制到实体类对象

        Purchase savedPurchase = purchaseRepository.save(purchase);

        PurchaseVO savedPurchaseVO = new PurchaseVO();
        savedPurchaseVO.setPurchaseNumber(savedPurchase.getPurchaseNumber());
        savedPurchaseVO.setItemName(savedPurchase.getItemName());
        savedPurchaseVO.setPurchaseAmount(savedPurchase.getPurchaseAmount());
        savedPurchaseVO.setPurchaseTime(savedPurchase.getPurchaseTime());
        // 再将保存后的实体类对象转换回VO对象返回

        return savedPurchaseVO;
    }

    /**
     * 根据采购单号删除采购数据的方法
     *
     * @param purchaseNumber 采购单号
     */
    public void deletePurchaseByNumber(String purchaseNumber) {
        Purchase purchase = purchaseRepository.findByPurchaseNumber(purchaseNumber);
        if (purchase!= null) {
            purchaseRepository.delete(purchase);
        }
    }
}