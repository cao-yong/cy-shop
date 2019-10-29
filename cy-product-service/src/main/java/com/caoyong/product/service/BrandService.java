package com.caoyong.product.service;


import com.caoyong.base.bean.ResultBase;
import com.caoyong.sw.bean.dto.BrandDTO;

/**
 * 品牌
 *
 * @author yong.cao
 * @time 2017年7月30日 下午9:32:53
 */
public interface BrandService {

    /**
     * 根据id查询品牌
     *
     * @param id 品牌id
     * @return 对应品牌
     */
    ResultBase<BrandDTO> selectBrandById(Long id);

}
