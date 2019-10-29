package com.caoyong.programs.controller;

import com.caoyong.base.bean.ResultBase;
import com.caoyong.programs.service.ShopService;
import com.caoyong.yzb.bean.dto.ShopDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoyong
 * @version 1.0.0
 * @since 2019/10/28 14:01
 **/
@Slf4j
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResultBase<ShopDTO> selectBrandById(@PathVariable Long id) {
        return shopService.selectShopById(id);
    }

}
