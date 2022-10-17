package com.ruoyi.project.contract.controller;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.contract.domain.Contract;
import com.ruoyi.project.contract.service.IContractService;
import com.ruoyi.project.system.domain.SysDept;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 合同管理Controller
 *
 * @author sherlock
 * @date 2022-10-17
 */
@RestController
@RequestMapping("/contract/manage")
public class ContractManageController extends BaseController
{
    @Autowired
    private IContractService contractService;

    /**
     * 查询合同管理列表
     */
    @PreAuthorize("@ss.hasPermi('contract:manage:list')")
    @GetMapping("/list")
    public AjaxResult list(Contract contract)
    {
        List<Contract> list = contractService.selectContractList(contract);
        return AjaxResult.success(list);
    }

    /**
     * 查询合同管理列表（排除节点）
     */
    @PreAuthorize("@ss.hasPermi('system:dept:list')")
    @GetMapping("/list/exclude/{contractId}")
    public AjaxResult excludeChild(@PathVariable(value = "contractId", required = false) Long contractId)
    {
        List<Contract> depts = contractService.selectContractList(new Contract());
        depts.removeIf(d -> d.getDeptId().intValue() == contractId || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), contractId + ""));
        return AjaxResult.success(depts);
    }



    /**
     * 导出合同管理列表
     */
    @PreAuthorize("@ss.hasPermi('contract:manage:export')")
    @Log(title = "合同管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Contract contract)
    {
        List<Contract> list = contractService.selectContractList(contract);
        ExcelUtil<Contract> util = new ExcelUtil<Contract>(Contract.class);
        util.exportExcel(response, list, "合同管理数据");
    }

    /**
     * 获取合同管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('contract:manage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(contractService.selectContractById(id));
    }

    /**
     * 新增合同管理
     */
    @PreAuthorize("@ss.hasPermi('contract:manage:add')")
    @Log(title = "合同管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Contract contract)
    {
        return toAjax(contractService.insertContract(contract));
    }

    /**
     * 修改合同管理
     */
    @PreAuthorize("@ss.hasPermi('contract:manage:edit')")
    @Log(title = "合同管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Contract contract)
    {
        return toAjax(contractService.updateContract(contract));
    }

    /**
     * 删除合同管理
     */
    @PreAuthorize("@ss.hasPermi('contract:manage:remove')")
    @Log(title = "合同管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(contractService.deleteContractByIds(ids));
    }
}
