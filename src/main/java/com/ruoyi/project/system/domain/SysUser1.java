package com.ruoyi.project.system.domain;

import com.ruoyi.common.xss.Xss;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.aspectj.lang.annotation.Excel.ColumnType;
import com.ruoyi.framework.aspectj.lang.annotation.Excel.Type;
import com.ruoyi.framework.aspectj.lang.annotation.Excels;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户对象 sys_user
 *
 * @author ruoyi
 */
public class SysUser1 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 真实姓名 */
    @Excel(name = "真实姓名")
    private String truename;

    /** 密码 */
    @Excel(name = "密码")
    private String pass;

    /** 角色 */
    @Excel(name = "角色")
    private Long roles;

    /** 状态 */
    @Excel(name = "状态")
    private Integer userState;

    /** 登录令牌 */
    @Excel(name = "登录令牌")
    private String token;

    /** web端登录令牌 */
    @Excel(name = "web端登录令牌")
    private String webToken;

    /** 用户手机号 */
    @Excel(name = "用户手机号")
    private String phone;

    /** 身份证号码 */
    @Excel(name = "身份证号码")
    private String idcard;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    public void setTruename(String truename)
    {
        this.truename = truename;
    }

    public String getTruename()
    {
        return truename;
    }
    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public String getPass()
    {
        return pass;
    }
    public void setRoles(Long roles)
    {
        this.roles = roles;
    }

    public Long getRoles()
    {
        return roles;
    }
    public void setUserState(Integer userState)
    {
        this.userState = userState;
    }

    public Integer getUserState()
    {
        return userState;
    }
    public void setToken(String token)
    {
        this.token = token;
    }

    public String getToken()
    {
        return token;
    }
    public void setWebToken(String webToken)
    {
        this.webToken = webToken;
    }

    public String getWebToken()
    {
        return webToken;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setIdcard(String idcard)
    {
        this.idcard = idcard;
    }

    public String getIdcard()
    {
        return idcard;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("username", getUsername())
                .append("truename", getTruename())
                .append("pass", getPass())
                .append("roles", getRoles())
                .append("userState", getUserState())
                .append("token", getToken())
                .append("webToken", getWebToken())
                .append("phone", getPhone())
                .append("idcard", getIdcard())
                .toString();
    }
}
