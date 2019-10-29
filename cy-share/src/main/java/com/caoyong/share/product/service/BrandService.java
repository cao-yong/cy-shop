package com.caoyong.share.product.service;


import com.caoyong.base.bean.ResultBase;
import com.caoyong.share.product.service.fallback.BrandServiceFallback;
import com.caoyong.sw.bean.dto.BrandDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 品牌
 *
 * @author yong.cao
 * @time 2017年7月30日 下午9:32:53
 */
@FeignClient(value = "PRODUCT-SERVICE", fallback = BrandServiceFallback.class)
@RequestMapping("/product-service")
public interface BrandService {

    /**
     * 根据id查询品牌
     *
     * @param id 品牌id
     * @return 对应品牌
     */
    @RequestMapping(value = "/brand/{id}", method = RequestMethod.GET)
    ResultBase<BrandDTO> selectBrandById(@PathVariable("id") Long id);

}
