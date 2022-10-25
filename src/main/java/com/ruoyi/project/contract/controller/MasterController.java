package com.ruoyi.project.contract.controller;/**
 * 功能描述
 *
 * @author: sherlock
 * @date: 2022年10月20日 16:11
 */

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.client.MasterServiceClient;
import com.ruoyi.project.client.bean.GenericClientResponse;
import com.ruoyi.project.client.bean.MasterCustomerModel;
import com.ruoyi.project.client.bean.MasterGoodsModel;
import com.ruoyi.project.common.RestTemplateUtils;
import com.ruoyi.project.contract.domain.Contract;
import com.ruoyi.project.contract.service.IMasterService;
import com.ruoyi.project.system.service.impl.SysUserServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author: Sherlock
 * @date: 2022年10月20日 16:11
 */
@RequestMapping("/master")
@RestController
public class MasterController {

    private static final Logger log = LoggerFactory.getLogger(MasterController.class);

    @Autowired
    public IMasterService masterService;
    /**
     * 获取客商信息
     * @return 公司模型
     */
    @RequestMapping(method = RequestMethod.POST, value = "/company")
    public AjaxResult getMasterCompanyData(@RequestBody JSONObject body) {
        Object results= body.get("masterData");

        List<JSONObject> res = JSON.parseArray(String.valueOf(results),JSONObject.class);
        List<MasterCustomerModel> models = new ArrayList<>();
        try {
            if (res.size() >0){
                for (JSONObject o : res){
                    MasterCustomerModel model = new MasterCustomerModel();
                    if (o.getString("mdm_code") == null)
                    {
                        log.info("对应的reults值 "+results);
                        throw new ServiceException("主数据 mdm_code为空 :" + o.toString());
                    }
                    else {
                        model.setMdmCode(o.getString("mdm_code"));
                    }
                    if (o.getString("cv_name") == null)
                    {
                        throw new ServiceException("主数据 cv_name 为空:" + o.toString());
                    }
                    else {
                        model.setCvName(o.getString("cv_name"));
                    }

                    model.setCvCode(o.getString("cv_code"));
                    model.setCvCity(o.getString("cv_city"));
                    model.setCvLegalPerson(o.getString("cv_legal_person"));
                    model.setCvProvince(o.getString("cv_province"));
                    model.setCvState(o.getString("cv_state"));
                    model.setCvType(o.getString("cv_type"));
                    models.add(model);
                }
            } else{
                throw new ServiceException("主数据分发0条");
            }
            masterService.insertMasterCustomer(models);
        }
        catch (Exception ex) {
            log.info("对应的body值 "+body);
            log.info("对应的masterData值 "+results);
            log.error("主数据解析失败:" + ex);
        }
        return AjaxResult.success("客商信息分发成功："+ res.size() + "条");
    }

    /**
     * 获取物资主数据列表
     * @param body
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/goods")
    public AjaxResult getMasterGoodsData(@RequestBody JSONObject body) {

        JSONObject jsonObject = JSONObject.parseObject(body.toString());
        Object results= jsonObject.get("masterData");

        List<JSONObject> res = JSON.parseArray(String.valueOf(results),JSONObject.class);
        List<MasterGoodsModel> models = new ArrayList<>();
        try {
            if (res.size() >0){
                for (JSONObject o : res){
                    MasterGoodsModel model = new MasterGoodsModel();
                    if (o.getString("mdm_code") == null)
                    {
                        log.info("对应的reults值 "+results);
                        throw new ServiceException("主数据 mdm_code为空 :" + o.toString());
                    }
                    else {
                        model.setMdmCode(o.getString("mdm_code"));
                    }
                    if (o.getString("wz_name") == null)
                    {
                        throw new ServiceException("主数据 wz_name 为空:" + o.toString());
                    }
                    else {
                        model.setWzName(o.getString("wz_name"));
                    }

                    model.setWzJldwName(o.getString("wz_jldw_name"));
                    model.setWzGuige(o.getString("wz_guige"));
                    models.add(model);
                }
            } else{
                throw new ServiceException("主数据分发0条");
            }
            masterService.insertMasterGoods(models);
        }
         catch (Exception ex) {
             log.info("对应的body值 "+body);
             log.info("对应的masterData值 "+results);
             log.error("主数据解析失败:" + ex);
        }
        return AjaxResult.success("物资主数据分发成功："+ res.size() + "条");
    }


    /**
     * 查询货品列表
     */
    @ApiOperation(value = "查询物资主数据货品列表 --作者：sherlock")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 401, message = "验证失败"),
            @ApiResponse(code = 404, message = "未找到"),
            @ApiResponse(code = 500, message = "内部程序错误")
    })
    @PreAuthorize("@ss.hasPermi('contract:manage:list')")
    @GetMapping("/goods/list")
    public AjaxResult goodslist(String masterdataid)
    {
        List<MasterGoodsModel> list = masterService.getMasterGoodsList(masterdataid);
        return AjaxResult.success(list);
    }

    /**
     * 查询客商信息主数据列表
     */
    @ApiOperation(value = "查询客商信息主数据货品列表 --作者：sherlock")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 401, message = "验证失败"),
            @ApiResponse(code = 404, message = "未找到"),
            @ApiResponse(code = 500, message = "内部程序错误")
    })
    @PreAuthorize("@ss.hasPermi('contract:manage:list')")
    @GetMapping("/customer/list")
    public AjaxResult list(String masterdataid)
    {
        List<MasterCustomerModel> list = masterService.getMasterCustomerList(masterdataid);
        return AjaxResult.success(list);
    }
}
