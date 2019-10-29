package com.caoyong.share.programs.service;


import com.caoyong.base.bean.ResultBase;
import com.caoyong.share.programs.service.fallback.ShopServiceFallback;
import com.caoyong.yzb.bean.dto.ShopDTO;
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
@FeignClient(value = "PROGRAMS-SERVICE", fallback = ShopServiceFallback.class)
@RequestMapping("/programs-service")
public interface ShopService {

    /**
     * 根据id查询店铺
     *
     * @param id 店铺id
     * @return 对应店铺
     */
    @RequestMapping(value = "/shop/{id}", method = RequestMethod.GET)
    ResultBase<ShopDTO> selectShopById(@PathVariable("id") Long id);

}
