package com.manage.gdpu.service;

import com.manage.gdpu.entity.Finance;
import com.manage.gdpu.repository.FinanceRepository;
import com.manage.gdpu.vo.FinanceDataVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinanceService {

    private final FinanceRepository financeRepository;

    public FinanceService(FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }

    /**
     * 获取所有财务数据的方法，添加将实体类转换为VO类的逻辑
     *
     * @return 返回包含所有财务数据的VO列表，若数据库中无数据则返回空列表
     */
    public List<FinanceDataVO> getFinanceData() {
        List<Finance> financeList = financeRepository.findAll();
        List<FinanceDataVO> financeVOList = new ArrayList<>();
        for (Finance finance : financeList) {
            FinanceDataVO financeVO = new FinanceDataVO();
            // 将实体类的属性值复制到VO类对应的属性中
            financeVO.setId(finance.getId());
            financeVO.setFinanceName(finance.getFinanceName());
            financeVO.setAmount(finance.getAmount());
            financeVO.setDescription(finance.getDescription());
            // 可以根据实际情况补充更多属性的赋值，比如所属项目等关联信息

            financeVOList.add(financeVO);
        }
        return financeVOList;
    }

    /**
     * 根据财务记录ID获取特定财务数据的方法，同样进行类型转换
     *
     * @param financeId 财务记录ID
     * @return 返回特定的财务数据的VO对象，如果不存在则返回null
     */
    public FinanceDataVO getFinanceById(Long financeId) {
        Finance finance = financeRepository.findById(financeId).orElse(null);
        if (finance!= null) {
            FinanceDataVO financeVO = new FinanceDataVO();
            financeVO.setId(finance.getId());
            financeVO.setFinanceName(finance.getFinanceName());
            financeVO.setAmount(finance.getAmount());
            financeVO.setDescription(finance.getDescription());
            // 按需补充更多属性赋值
            return financeVO;
        }
        return null;
    }

    /**
     * 保存财务数据（新增或更新财务记录）的方法，此处可根据需要添加逻辑确保VO和实体类数据的转换及保存正确
     *
     * @param financeVO 要保存的财务数据的VO对象
     * @return 保存后的财务数据的VO对象
     */
    public FinanceDataVO saveFinance(FinanceDataVO financeVO) {
        Finance finance = new Finance();
        finance.setId(financeVO.getId());
        finance.setFinanceName(financeVO.getFinanceName());
        finance.setAmount(financeVO.getAmount());
        finance.setDescription(financeVO.getDescription());
        // 同样处理其他相关属性，将VO属性值复制到实体类对象

        Finance savedFinance = financeRepository.save(finance);

        FinanceDataVO savedFinanceVO = new FinanceDataVO();
        savedFinanceVO.setId(savedFinance.getId());
        savedFinanceVO.setFinanceName(savedFinance.getFinanceName());
        savedFinanceVO.setAmount(savedFinance.getAmount());
        savedFinanceVO.setDescription(savedFinance.getDescription());
        // 再次处理属性赋值，将保存后的实体类对象转换回VO对象返回

        return savedFinanceVO;
    }

    /**
     * 根据财务记录ID删除财务数据的方法
     *
     * @param financeId 财务记录ID
     */
    public void deleteFinanceById(Long financeId) {
        financeRepository.deleteById(financeId);
    }
}