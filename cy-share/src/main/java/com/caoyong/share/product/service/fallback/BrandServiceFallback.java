package com.caoyong.share.product.service.fallback;

import com.caoyong.base.bean.ResultBase;
import com.caoyong.share.product.service.BrandService;
import com.caoyong.sw.bean.dto.BrandDTO;
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
public class BrandServiceFallback implements BrandService {
    @Override
    public ResultBase<BrandDTO> selectBrandById(Long id) {
        log.error("PRODUCT-SERVICE unavailable");
        return new ResultBase<>();
    }
}
