package com.ruoyi.project.client.bean;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
/**
 * 客商信息对象
 *
 * @author: Sherlock
 * @date: 2022年10月20日 16:08
 */
public class MasterCustomerModel {

    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 客商主数据编码 */
    @Excel(name = "客商主数据编码")
    private String mdmCode;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String cvName;

    /** 统一信用代码 */
    @Excel(name = "统一信用代码")
    private String cvCode;

    /** 公司类型 */
    @Excel(name = "公司类型")
    private String cvType;

    /** 省/直辖市 */
    @Excel(name = "省/直辖市")
    private String cvProvince;

    /** 城市 */
    @Excel(name = "城市")
    private String cvCity;

    /** 法定代表人 */
    @Excel(name = "法定代表人")
    private String cvLegalPerson;

    /** 经营状态 */
    @Excel(name = "经营状态")
    private String cvState;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMdmCode() {
        return mdmCode;
    }

    public void setMdmCode(String mdmCode) {
        this.mdmCode = mdmCode;
    }

    public String getCvName() {
        return cvName;
    }

    public void setCvName(String cvName) {
        this.cvName = cvName;
    }

    public String getCvCode() {
        return cvCode;
    }

    public void setCvCode(String cvCode) {
        this.cvCode = cvCode;
    }

    public String getCvType() {
        return cvType;
    }

    public void setCvType(String cvType) {
        this.cvType = cvType;
    }

    public String getCvProvince() {
        return cvProvince;
    }

    public void setCvProvince(String cvProvince) {
        this.cvProvince = cvProvince;
    }

    public String getCvCity() {
        return cvCity;
    }

    public void setCvCity(String cvCity) {
        this.cvCity = cvCity;
    }

    public String getCvLegalPerson() {
        return cvLegalPerson;
    }

    public void setCvLegalPerson(String cvLegalPerson) {
        this.cvLegalPerson = cvLegalPerson;
    }

    public String getCvState() {
        return cvState;
    }

    public void setCvState(String cvState) {
        this.cvState = cvState;
    }
}
