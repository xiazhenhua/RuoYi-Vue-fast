package com.ruoyi.project.client.bean;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * 功能描述
 *
 * @author: Sherlock
 * @date: 2022年10月21日 9:12
 */

public class MasterGoodsModel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 物资主数据编码 */
    @Excel(name = "物资主数据编码")
    private String mdmCode;

    /** 物资名称 */
    @Excel(name = "物资名称")
    private String wzName;

    /** 计量单位 */
    @Excel(name = "计量单位")
    private String wzJldwName;

    /** 规格 */
    @Excel(name = "规格")
    private String wzGuige;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setMdmCode(String mdmCode)
    {
        this.mdmCode = mdmCode;
    }

    public String getMdmCode()
    {
        return mdmCode;
    }
    public void setWzName(String wzName)
    {
        this.wzName = wzName;
    }

    public String getWzName()
    {
        return wzName;
    }
    public void setWzJldwName(String wzJldwName)
    {
        this.wzJldwName = wzJldwName;
    }

    public String getWzJldwName()
    {
        return wzJldwName;
    }
    public void setWzGuige(String wzGuige)
    {
        this.wzGuige = wzGuige;
    }

    public String getWzGuige()
    {
        return wzGuige;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("mdmCode", getMdmCode())
                .append("wzName", getWzName())
                .append("wzJldwName", getWzJldwName())
                .append("wzGuige", getWzGuige())
                .toString();
    }
}

