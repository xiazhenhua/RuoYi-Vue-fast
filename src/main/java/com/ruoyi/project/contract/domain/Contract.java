package com.ruoyi.project.contract.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.TreeEntity;

/**
 * 合同管理对象 contract
 *
 * @author sherlock
 * @date 2022-10-17
 */
@ApiModel(value = "Contract", description = "合同实体")
public class Contract extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    @ApiModelProperty("自增主键")
    private Long id;

    /** 父节点id */
    @Excel(name = "父节点id")
    @ApiModelProperty("父节点id")
    private Long parentId;

    /** 合同类型：采购、销售  根据字典值 */
    @Excel(name = "合同类型：采购、销售  根据字典值")
    @ApiModelProperty("合同类型：采购1、销售0  根据字典值 ")
    private Integer contractType;

    /** 业务类型：经销、代销、联营、包销、对方发货  根据字典值 */
    @Excel(name = "业务类型：经销、代销、联营、包销、对方发货  根据字典值")
    @ApiModelProperty("业务类型：经销、代销、联营、包销、对方发货  根据字典值")
    private Integer businessType;

    /** 付款类型：先款后货  根据字典值 */
    @Excel(name = "付款类型：先款后货  根据字典值")
    @ApiModelProperty("付款类型：先款后货  根据字典值")
    private Integer payType;

    /** 合同编号 */
    @Excel(name = "合同编号")
    @ApiModelProperty("合同编号")
    private String number;

    /** 货品编号 品种 */
    @Excel(name = "货品编号 品种")
    @ApiModelProperty("货品编号 品种")
    private String productNo;

    /** 合同约定指标 */
    @Excel(name = "合同约定指标")
    @ApiModelProperty("合同约定指标")
    private String target;

    /** 计价方式 */
    @Excel(name = "计价方式")
    @ApiModelProperty("计价方式")
    private Integer priceMethod;

    /** 图片地址 */
    @Excel(name = "图片地址")
    @ApiModelProperty("图片地址")
    private String photoUrl;

    /** 货物来源 */
    @Excel(name = "货物来源")
    @ApiModelProperty("货物来源")
    private String source;

    /** 单价 */
    @Excel(name = "单价")
    @ApiModelProperty("单价")
    private BigDecimal price;

    /** 删除标志（0代表存在 2代表删除） */
    @ApiModelProperty("删除标志（0代表存在 2代表删除）")
    private String delFlag;

    /** 采购数量 */
    @Excel(name = "采购数量")
    @ApiModelProperty("采购数量")
    private Long quantity;

    /** 附加费用 */
    @Excel(name = "附加费用")
    @ApiModelProperty("附加费用")
    private BigDecimal additionalCharges;

    /** 附加来源 */
    @Excel(name = "附加来源")
    @ApiModelProperty("附加来源")
    private String additionalSource;

    /** 不含税总金额 */
    @Excel(name = "不含税总金额")
    @ApiModelProperty("不含税总金额")
    private BigDecimal totalAmountExcludeTax;

    /** 税率 */
    @Excel(name = "税率")
    @ApiModelProperty("税率")
    private BigDecimal tax;

    /** 含税总金额 */
    @Excel(name = "含税总金额")
    @ApiModelProperty("含税总金额")
    private BigDecimal totalAmountIncludeTax;

    /** 部门ID */
    @Excel(name = "部门ID")
    @ApiModelProperty("部门ID")
    private Long deptId;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    @ApiModelProperty("供应商ID")
    private String supplierId;

    /** 需求商ID */
    @Excel(name = "需求商ID")
    @ApiModelProperty("需求商ID")
    private String demandId;

    /** 合同签订日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("合同签订日期")
    private Date signingDate;

    /** 生效开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生效开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("生效开始日期")
    private Date validateDateBegin;

    /** 生效结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生效结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("生效结束日期")
    private Date validateDateEnd;

    /** 扣罚标准 */
    @Excel(name = "扣罚标准")
    @ApiModelProperty("扣罚标准")
    private String penalizeStandard;

    /** 交货地 */
    @Excel(name = "交货地")
    @ApiModelProperty("交货地")
    private String place;

    /** 备注 */
    @Excel(name = "备注")
    @ApiModelProperty("备注")
    private String remarks;

    /** 执行状态：-1已作废0未执行1已执行2已完结 */
    @Excel(name = "执行状态：-1已作废0未执行1已执行2已完结")
    @ApiModelProperty("执行状态：-1已作废0未执行1已执行2已完结")
    private Integer status;

    /** 记录生成人 */
    @Excel(name = "记录生成人")
    @ApiModelProperty("记录生成人")
    private String createPerson;

    /** 记录生成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录生成时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("记录生成时间")
    private Date createDate;

    /** 更新人 */
    @Excel(name = "更新人")
    @ApiModelProperty("更新人")
    private String updatePerson;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("更新时间")
    private Date updateDate;

    /** 子合同 */
    private List<Contract> children = new ArrayList<>();


    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    @Override
    public Long getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setContractType(Integer contractType)
    {
        this.contractType = contractType;
    }

    public Integer getContractType()
    {
        return contractType;
    }
    public void setBusinessType(Integer businessType)
    {
        this.businessType = businessType;
    }

    public Integer getBusinessType()
    {
        return businessType;
    }
    public void setPayType(Integer payType)
    {
        this.payType = payType;
    }

    public Integer getPayType()
    {
        return payType;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getNumber()
    {
        return number;
    }
    public void setProductNo(String productNo)
    {
        this.productNo = productNo;
    }

    public String getProductNo()
    {
        return productNo;
    }
    public void setTarget(String target)
    {
        this.target = target;
    }

    public String getTarget()
    {
        return target;
    }

    public Integer getPriceMethod() {
        return priceMethod;
    }

    public void setPriceMethod(Integer priceMethod) {
        this.priceMethod = priceMethod;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getSource()
    {
        return source;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setQuantity(Long quantity)
    {
        this.quantity = quantity;
    }

    public Long getQuantity()
    {
        return quantity;
    }
    public void setAdditionalCharges(BigDecimal additionalCharges)
    {
        this.additionalCharges = additionalCharges;
    }

    public BigDecimal getAdditionalCharges()
    {
        return additionalCharges;
    }
    public void setAdditionalSource(String additionalSource)
    {
        this.additionalSource = additionalSource;
    }

    public String getAdditionalSource()
    {
        return additionalSource;
    }
    public void setTotalAmountExcludeTax(BigDecimal totalAmountExcludeTax)
    {
        this.totalAmountExcludeTax = totalAmountExcludeTax;
    }

    public BigDecimal getTotalAmountExcludeTax()
    {
        return totalAmountExcludeTax;
    }
    public void setTax(BigDecimal tax)
    {
        this.tax = tax;
    }

    public BigDecimal getTax()
    {
        return tax;
    }
    public void setTotalAmountIncludeTax(BigDecimal totalAmountIncludeTax)
    {
        this.totalAmountIncludeTax = totalAmountIncludeTax;
    }

    public BigDecimal getTotalAmountIncludeTax()
    {
        return totalAmountIncludeTax;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setSupplierId(String supplierId)
    {
        this.supplierId = supplierId;
    }

    public String getSupplierId()
    {
        return supplierId;
    }
    public void setDemandId(String demandId)
    {
        this.demandId = demandId;
    }

    public String getDemandId()
    {
        return demandId;
    }
    public void setSigningDate(Date signingDate)
    {
        this.signingDate = signingDate;
    }

    public Date getSigningDate()
    {
        return signingDate;
    }
    public void setValidateDateBegin(Date validateDateBegin)
    {
        this.validateDateBegin = validateDateBegin;
    }

    public Date getValidateDateBegin()
    {
        return validateDateBegin;
    }
    public void setValidateDateEnd(Date validateDateEnd)
    {
        this.validateDateEnd = validateDateEnd;
    }

    public Date getValidateDateEnd()
    {
        return validateDateEnd;
    }
    public void setPenalizeStandard(String penalizeStandard)
    {
        this.penalizeStandard = penalizeStandard;
    }

    public String getPenalizeStandard()
    {
        return penalizeStandard;
    }
    public void setPlace(String place)
    {
        this.place = place;
    }

    public String getPlace()
    {
        return place;
    }
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRemarks()
    {
        return remarks;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setCreatePerson(String createPerson)
    {
        this.createPerson = createPerson;
    }

    public String getCreatePerson()
    {
        return createPerson;
    }
    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getCreateDate()
    {
        return createDate;
    }
    public void setUpdatePerson(String updatePerson)
    {
        this.updatePerson = updatePerson;
    }

    public String getUpdatePerson()
    {
        return updatePerson;
    }
    public void setUpdateDate(Date updateDate)
    {
        this.updateDate = updateDate;
    }

    public Date getUpdateDate()
    {
        return updateDate;
    }

    @Override
    public List<Contract> getChildren() {
        return children;
    }
    public void setChildren1(List<Contract> children)
    {
        this.children = children;
    }



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pid", getParentId())
            .append("ancestors", getAncestors())
            .append("contractType", getContractType())
            .append("businessType", getBusinessType())
            .append("payType", getPayType())
            .append("number", getNumber())
            .append("productNo", getProductNo())
            .append("target", getTarget())
            .append("priceMethod", getPriceMethod())
            .append("source", getSource())
            .append("price", getPrice())
            .append("quantity", getQuantity())
            .append("additionalCharges", getAdditionalCharges())
            .append("additionalSource", getAdditionalSource())
            .append("totalAmountExcludeTax", getTotalAmountExcludeTax())
            .append("tax", getTax())
            .append("totalAmountIncludeTax", getTotalAmountIncludeTax())
            .append("deptId", getDeptId())
            .append("supplierId", getSupplierId())
            .append("demandId", getDemandId())
            .append("signingDate", getSigningDate())
            .append("validateDateBegin", getValidateDateBegin())
            .append("validateDateEnd", getValidateDateEnd())
            .append("penalizeStandard", getPenalizeStandard())
            .append("place", getPlace())
            .append("remarks", getRemarks())
            .append("status", getStatus())
            .append("createPerson", getCreatePerson())
            .append("createDate", getCreateDate())
            .append("updatePerson", getUpdatePerson())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}
