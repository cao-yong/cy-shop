package com.caoyong.programs.service;


import com.caoyong.base.bean.ResultBase;
import com.caoyong.yzb.bean.dto.ShopDTO;

/**
 * 店铺
 *
 * @author yong.cao
 * @since 2017年7月30日 下午9:32:53
 */
public interface ShopService {

    /**
     * 根据id查询店铺
     *
     * @param id 店铺id
     * @return 对应店铺
     */
    ResultBase<ShopDTO> selectShopById(Long id);

}
