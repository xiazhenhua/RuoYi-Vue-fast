package com.ruoyi.project.contract.service;

import com.ruoyi.project.client.bean.MasterCustomerModel;
import com.ruoyi.project.client.bean.MasterGoodsModel;
import com.ruoyi.project.contract.domain.Contract;
import java.util.List;

/**
 * 主数据处理
 *
 * @author: sherlock
 * @date: 2022年10月21日 15:04
 */
public interface IMasterService {

    /**
     * 新增物资主数据
     *
     * @param models 物资主数据
     * @return 结果
     */
    public int insertMasterGoods(List<MasterGoodsModel> models);


    /**
     * 新增客商信息主数据
     *
     * @param models 客商信息主数据
     * @return 结果
     */
    public int insertMasterCustomer(List<MasterCustomerModel> models);


    /**
     * 查询物资主数据列表
     *
     * @return 结果
     */
    public List<MasterGoodsModel> getMasterGoodsList();

    /**
     * 查询客商信息主数据列表
     *
     * @return 结果
     */
    public List<MasterCustomerModel> getMasterCustomerList();
}
