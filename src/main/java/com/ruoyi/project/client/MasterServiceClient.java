package com.ruoyi.project.client;

import com.ruoyi.project.client.bean.MasterCustomerModel;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 功能描述
 * 获取集团主数据接口
 *
 * @author: sherlock
 * @date: 2022年10月20日 15:43
 */
public interface MasterServiceClient {

    /**
     * 获取客商信息
     * @return 公司模型
     */
    @RequestMapping(method = RequestMethod.POST, value = "/company/list", consumes = "application/json;charset=UTF-8")
    List<MasterCustomerModel> getMasterCompanyData();



}
