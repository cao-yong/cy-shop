package com.caoyong.share.programs.service.fallback;

import com.caoyong.base.bean.ResultBase;
import com.caoyong.share.programs.service.ShopService;
import com.caoyong.yzb.bean.dto.ShopDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author caoyong
 * @version 1.0.0
 * @since 2019/10/28 19:36
 **/
@Slf4j
@Component
@RequestMapping("/fallback")
public class ShopServiceFallback implements ShopService {
    @Override
    public ResultBase<ShopDTO> selectShopById(Long id) {
        log.error("PROGRAMS-SERVICE unavailable");
        return new ResultBase<>();
    }
}
