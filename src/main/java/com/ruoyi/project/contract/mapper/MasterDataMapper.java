package com.ruoyi.project.contract.mapper;

import com.ruoyi.project.client.bean.MasterCustomerModel;
import com.ruoyi.project.client.bean.MasterGoodsModel;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 功能描述
 *
 * @author: sherlock
 * @date: 2022年10月21日 15:16
 */
public interface MasterDataMapper {



    /**
     * 批量新增物资主数据
     *
     * @param models 物资
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
    public List<MasterGoodsModel> getMasterGoodsList(@Param("masterdataIds") List<String> masterdataIds);

    /**
     * 查询客商信息主数据列表
     *
     * @return 结果
     */
    public List<MasterCustomerModel> getMasterCustomerList(@Param("masterdataIds") List<String> masterdataIds);

}
