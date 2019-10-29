package com.caoyong.programs.shop.controller;

import com.caoyong.base.bean.ResultBase;
import com.caoyong.share.programs.service.ShopService;
import com.caoyong.yzb.bean.dto.ShopDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoyong
 * @version 1.0.0
 * @since 2019/10/28 20:11
 **/
@RestController
@RequestMapping("/shop")
@Api(value = "店铺相关接口", tags = {"店铺操作接口"})
public class ShopController {
    @Autowired
    private ShopService shopService;

    @ApiOperation(value = "通过店铺id查询店铺信息", notes = "", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResultBase<ShopDTO> get(@PathVariable @ApiParam(value = "店铺id") Long id) {
        return shopService.selectShopById(id);
    }
}
