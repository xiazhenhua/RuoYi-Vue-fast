package com.ruoyi.project.contract.mapper;

import com.ruoyi.project.contract.domain.Contract;
import java.util.List;

/**
 * 合同管理Mapper接口
 *
 * @author sherlock
 * @date 2022-10-17
 */
public interface ContractMapper
{
    /**
     * 查询合同管理
     *
     * @param id 合同管理主键
     * @return 合同管理
     */
    public Contract selectContractById(Long id);

    /**
     * 查询合同管理列表
     *
     * @param contract 合同管理
     * @return 合同管理集合
     */
    public List<Contract> selectContractList(Contract contract);

    /**
     * 新增合同管理
     *
     * @param contract 合同管理
     * @return 结果
     */
    public int insertContract(Contract contract);

    /**
     * 修改合同管理
     *
     * @param contract 合同管理
     * @return 结果
     */
    public int updateContract(Contract contract);

    /**
     * 删除合同管理
     *
     * @param id 合同管理主键
     * @return 结果
     */
    public int deleteContractById(Long id);

    /**
     * 批量删除合同管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteContractByIds(Long[] ids);
}
