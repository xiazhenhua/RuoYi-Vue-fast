package com.ruoyi.project.contract.service.impl;

import com.ruoyi.framework.aspectj.lang.annotation.DataScope;
import com.ruoyi.framework.web.domain.TreeSelect;
import com.ruoyi.project.contract.domain.Contract;
import com.ruoyi.project.contract.mapper.ContractMapper;
import com.ruoyi.project.contract.service.IContractService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 合同管理Service业务层处理
 *
 * @author sherlock
 * @date 2022-10-17
 */
@Service
public class ContractServiceImpl implements IContractService
{
    @Autowired
    private ContractMapper contractMapper;

    /**
     * 查询合同管理
     *
     * @param id 合同管理主键
     * @return 合同管理
     */
    @Override
    public Contract selectContractById(Long id)
    {
        return contractMapper.selectContractById(id);
    }

    /**
     * 查询合同管理树
     *
     * @param contract
     * @return
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<TreeSelect> selectContractTree(Contract contract) {

        List<Contract> contractList = contractMapper.selectContractList(contract);
//        List<TreeSelect> conTreeSelectList = ini
        return null;
    }

    /**
     * 查询合同管理树 (排除下级)
     *
     * @param contract
     * @return
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<TreeSelect> selectContractTreeExcludeChild(Contract contract) {
        return null;
    }

    /**
     * 查询合同管理列表
     *
     * @param contract 合同管理
     * @return 合同管理
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<Contract> selectContractList(Contract contract)
    {
        return contractMapper.selectContractList(contract);
    }

    /**
     * 新增合同管理
     *
     * @param contract 合同管理
     * @return 结果
     */
    @Override
    public int insertContract(Contract contract)
    {
        return contractMapper.insertContract(contract);
    }

    /**
     * 修改合同管理
     *
     * @param contract 合同管理
     * @return 结果
     */
    @Override
    public int updateContract(Contract contract)
    {
        return contractMapper.updateContract(contract);
    }

    /**
     * 批量删除合同管理
     *
     * @param ids 需要删除的合同管理主键
     * @return 结果
     */
    @Override
    public int deleteContractByIds(Long[] ids)
    {
        return contractMapper.deleteContractByIds(ids);
    }

    /**
     * 删除合同管理信息
     *
     * @param id 合同管理主键
     * @return 结果
     */
    @Override
    public int deleteContractById(Long id)
    {
        return contractMapper.deleteContractById(id);
    }
}
