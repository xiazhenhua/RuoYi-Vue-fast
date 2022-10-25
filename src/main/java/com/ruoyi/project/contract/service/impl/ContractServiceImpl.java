package com.ruoyi.project.contract.service.impl;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.framework.aspectj.lang.annotation.DataScope;
import com.ruoyi.framework.web.domain.TreeSelect;
import com.ruoyi.project.contract.domain.Contract;
import com.ruoyi.project.contract.mapper.ContractMapper;
import com.ruoyi.project.contract.service.IContractService;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
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

        List<Contract> contracts = SpringUtils.getAopProxy(this).selectContractList(true,contract);
        return buildContractTreeList(contracts);
    }

    /**
     * 构建前端需要的下拉树结构 1
     * @param contracts
     * @return
     */

    public List<TreeSelect> buildContractTreeList(List<Contract> contracts){
        List<Contract> contractTrees = buildContractTree(contracts);
        return contractTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }
    /**
     * 构建前端需要的下拉树结构 2
     * @param contracts
     * @return
     */

    public List<Contract> buildContractTree(List<Contract> contracts){
        List<Contract> returnList = new ArrayList<Contract>();
        List<Long> tempList = contracts.stream().map(Contract::getId).collect(Collectors.toList());
        for(Contract contract : contracts){
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(contract.getParentId()))
            {
                recursionFn(contracts, contract);
                returnList.add(contract);
            }
        }
        if (returnList.isEmpty()){
            returnList = contracts;
        }
        return returnList;
    }

    /**
     * 递归列表
     * @param list
     * @param c
     */
    private void recursionFn(List<Contract> list,Contract c)
    {
        // 得到子节点列表
        List<Contract> childList = getChildList(list, c);
        c.setChildren(childList);
        for (Contract tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }
    /**
     * 得到子节点列表
     */
    private List<Contract> getChildList(List<Contract> list, Contract t)
    {
        List<Contract> tlist = new ArrayList<Contract>();
        Iterator<Contract> it = list.iterator();
        while (it.hasNext())
        {
            Contract n = (Contract) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getDeptId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<Contract> list, Contract t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }



    /**
     * 查询合同管理列表
     *
     * @param contract 合同管理
     * @return 合同管理
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<Contract> selectContractList(boolean flag ,Contract contract)
    {
        if (flag){
//            如果是采购合同 查询ContractType = 1
            contract.setContractType(1);
        }else{
            contract.setContractType(0);
        }
        if (contract.getDates() != null){
            Date startDate = contract.getDates()[0];
            if (contract.getDates().length > 1){
                Date endDate = contract.getDates()[1];
                contract.setEndDate(endDate);
            }
            contract.setStartDate(startDate);
        }
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
        Contract c = contractMapper.selectContractById(contract.getId());
        if (c != null){
            contract.setAncestors(c.getAncestors() + "," + contract.getParentId());
        }
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
        Contract newParentContract = contractMapper.selectContractById(contract.getParentId());
        Contract oldParentContract = contractMapper.selectContractById(contract.getId());

        if (StringUtils.isNotNull(newParentContract) && StringUtils.isNotNull(oldParentContract)){
            String newAncestors = newParentContract.getAncestors() + "," + newParentContract.getDeptId();
            String oldAncestors = oldParentContract.getAncestors();
            contract.setAncestors(newAncestors);
            contract.setAncestors(newAncestors);
            updateDeptChildren(contract.getId(), newAncestors, oldAncestors);
        }

        return contractMapper.updateContract(contract);
    }


    /**
     * 修改子元素关系
     *
     * @param id 被修改的合同ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateDeptChildren(Long id, String newAncestors, String oldAncestors)
    {
        List<Contract> children = contractMapper.selectChildrenContractById(id);
        for (Contract child : children)
        {
            child.setAncestors(child.getAncestors().replaceFirst(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            contractMapper.updateContractChildren(children);
        }
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
        for(Long l : ids){
            int t = contractMapper.selectParentContract(l);
            if (t > 0)
            {
                throw new ServiceException("存在子合同，不允许删除");
            }
        }
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
        if (contractMapper.selectParentContract(id) > 0)
        {
            throw new ServiceException("存在子合同，不允许删除");
        }else{
            return contractMapper.deleteContractById(id);
        }

    }
}
