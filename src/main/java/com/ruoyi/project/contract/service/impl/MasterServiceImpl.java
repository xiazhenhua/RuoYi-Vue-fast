package com.ruoyi.project.contract.service.impl;/**
 * 功能描述
 *
 * @author: sherlock
 * @date: 2022年10月21日 15:13
 */

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.project.client.bean.MasterCustomerModel;
import com.ruoyi.project.client.bean.MasterGoodsModel;
import com.ruoyi.project.contract.controller.MasterController;
import com.ruoyi.project.contract.mapper.ContractMapper;
import com.ruoyi.project.contract.mapper.MasterDataMapper;
import com.ruoyi.project.contract.service.IMasterService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author: Sherlock
 * @date: 2022年10月21日 15:13
 */
@Service
public class MasterServiceImpl implements IMasterService {

    private static final Logger log = LoggerFactory.getLogger(MasterServiceImpl.class);
    @Autowired
    private MasterDataMapper masterDataMapper;
    /**
     * 新增物资主数据
     *
     * @param models 物资主数据
     * @return 结果
     */
    @Override
    public int insertMasterGoods(List<MasterGoodsModel> models) {

        if ((models.size() <=0))
        {
            throw new ServiceException("主数据为空");
        }
        log.info("主数据更新" + models.size() +"条");
        return masterDataMapper.insertMasterGoods(models);
    }

    /**
     * 新增客商信息主数据
     *
     * @param models 客商信息主数据
     * @return 结果
     */
    @Override
    public int insertMasterCustomer(List<MasterCustomerModel> models) {
        if ((models.size() <=0))
        {
            throw new ServiceException("主数据为空");
        }
        log.info("主数据更新" + models.size() +"条");
        return masterDataMapper.insertMasterCustomer(models);
    }

    /**
     * 查询物资主数据列表
     *
     * @return 结果
     */
    @Override
    public List<MasterGoodsModel> getMasterGoodsList() {
        return masterDataMapper.getMasterGoodsList();
    }

    /**
     * 查询客商信息主数据列表
     *
     * @return 结果
     */
    @Override
    public List<MasterCustomerModel> getMasterCustomerList() {
        return masterDataMapper.getMasterCustomerList();
    }


}
