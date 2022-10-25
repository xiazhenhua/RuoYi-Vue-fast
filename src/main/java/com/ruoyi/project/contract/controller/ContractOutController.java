package com.ruoyi.project.contract.controller;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.contract.domain.Contract;
import com.ruoyi.project.contract.service.IContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 合同管理Controller
 *  销售合同管理
 * @author sherlock
 * @date 2022-10-17
 */
@Api("销售合同管理")
@RestController
@RequestMapping("/contract/out")
public class ContractOutController extends BaseController
{
    @Autowired
    private IContractService contractService;



    /**
     * 查询合同管理列表
     */
    @ApiOperation(value = "查询销售合同管理列表 --作者：sherlock")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 401, message = "验证失败"),
            @ApiResponse(code = 404, message = "未找到"),
            @ApiResponse(code = 500, message = "内部程序错误")
    })
    @PreAuthorize("@ss.hasPermi('contract:out:list')")
    @GetMapping("/list")
    public AjaxResult outlist(Contract contract)
    {
        // 采购为true ，销售合同为false
        boolean flag = false;
        List<Contract> list = contractService.selectContractList(false,contract);
        return AjaxResult.success(list);
    }

    /**
     * 查询合同管理列表（排除节点）
     */
    @ApiOperation(value = "查询合同管理列表（排除节点） --作者：sherlock")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 401, message = "验证失败"),
            @ApiResponse(code = 404, message = "未找到"),
            @ApiResponse(code = 500, message = "内部程序错误")
    })
    @ApiImplicitParam(name = "contractId", value = "合同ID", required = true, dataType = "Long", paramType = "path", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermi('contract:out:list')")
    @GetMapping("/list/exclude/{contractId}")
    public AjaxResult excludeChild(@PathVariable(value = "contractId", required = false) Long contractId)
    {
        List<Contract> depts = contractService.selectContractList(false,new Contract());
        depts.removeIf(d -> d.getDeptId().intValue() == contractId || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), contractId + ""));
        return AjaxResult.success(depts);
    }



    /**
     * 导出合同管理列表
     */
    @ApiOperation(value = "导出合同管理列表 --作者：sherlock")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 401, message = "验证失败"),
            @ApiResponse(code = 404, message = "未找到"),
            @ApiResponse(code = 500, message = "内部程序错误")
    })
    @PreAuthorize("@ss.hasPermi('contract:out:export')")
    @Log(title = "合同管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Contract contract)
    {
        boolean falg = false;
        List<Contract> list = contractService.selectContractList(falg,contract);
        ExcelUtil<Contract> util = new ExcelUtil<Contract>(Contract.class);
        util.exportExcel(response, list, "合同管理数据");
    }

    /**
     * 获取合同管理详细信息
     */
    @ApiOperation(value = "根据ID集合查出合同 --作者：sherlock")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 401, message = "验证失败"),
            @ApiResponse(code = 404, message = "未找到"),
            @ApiResponse(code = 500, message = "内部程序错误")
    })
    @ApiImplicitParam(name = "id", value = "合同ID", required = true, dataType = "Long", paramType = "path", dataTypeClass = Long.class)
    @PreAuthorize("@ss.hasPermi('contract:out:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(contractService.selectContractById(id));
    }

    /**
     * 新增合同管理
     */
    @ApiOperation("新增合同管理")
    @PreAuthorize("@ss.hasPermi('contract:out:add')")
    @Log(title = "合同管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Contract contract)
    {
        return toAjax(contractService.insertContract(contract));
    }

    /**
     * 修改合同管理
     */
    @ApiOperation("修改合同")
    @PreAuthorize("@ss.hasPermi('contract:out:edit')")
    @Log(title = "合同管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Contract contract)
    {
        return toAjax(contractService.updateContract(contract));
    }


    /**
     * 删除合同管理
     */
    @ApiOperation(value = "删除合同管理" , notes = "根据url的id来获取工艺的详细信息")
    @ApiResponses({ @ApiResponse(code = 200, message = "成功"), @ApiResponse(code = 401, message = "验证失败"),
            @ApiResponse(code = 404, message = "未找到"), @ApiResponse(code = 500, message = "内部系统错误") })
    @ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "合同ID集合", required = true, dataType = "Long", paramType = "path", dataTypeClass = Long.class) })
    @PreAuthorize("@ss.hasPermi('contract:out:remove')")
    @Log(title = "合同管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(contractService.deleteContractByIds(ids));
    }
}
