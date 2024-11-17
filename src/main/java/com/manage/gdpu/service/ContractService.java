package com.manage.gdpu.service;

import com.manage.gdpu.entity.Contract;
import com.manage.gdpu.repository.ContractRepository;
import com.manage.gdpu.vo.ContractVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    /**
     * 获取所有合同数据的方法，添加将实体类转换为VO类的逻辑
     *
     * @return 返回包含所有合同数据的VO列表，若数据库中无数据则返回空列表
     */
    public List<ContractVO> getContractData() {
        List<Contract> contractList = contractRepository.findAll();
        List<ContractVO> contractVOList = new ArrayList<>();
        for (Contract contract : contractList) {
            ContractVO contractVO = new ContractVO();
            // 将实体类的属性值复制到VO类对应的属性中
            contractVO.setContractNumber(contract.getContractNumber());
            contractVO.setContractName(contract.getContractName());
            contractVO.setSigningParty(contract.getSigningParty());
            contractVO.setSigningTime(contract.getSigningTime());
            contractVO.setAmount(contract.getAmount());
            // 可以根据实际情况补充更多属性的赋值

            contractVOList.add(contractVO);
        }
        return contractVOList;
    }

    /**
     * 根据合同编号获取特定合同数据的方法，同样进行类型转换
     *
     * @param contractNumber 合同编号
     * @return 返回特定的合同数据的VO对象，如果不存在则返回null
     */
    public ContractVO getContractByNumber(String contractNumber) {
        Contract contract = contractRepository.findByContractNumber(contractNumber);
        if (contract!= null) {
            ContractVO contractVO = new ContractVO();
            contractVO.setContractNumber(contract.getContractNumber());
            contractVO.setContractName(contract.getContractName());
            contractVO.setSigningParty(contract.getSigningParty());
            contractVO.setSigningTime(contract.getSigningTime());
            contractVO.setAmount(contract.getAmount());
            // 按需补充更多属性赋值
            return contractVO;
        }
        return null;
    }
}