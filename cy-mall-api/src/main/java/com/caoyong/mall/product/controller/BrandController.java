package com.caoyong.mall.product.controller;

import com.caoyong.base.bean.ResultBase;
import com.caoyong.share.product.service.BrandService;
import com.caoyong.sw.bean.dto.BrandDTO;
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
@RequestMapping("/brand")
@Api(value = "品牌相关接口", tags = {"品牌操作接口"})
public class BrandController {
    @Autowired
    private BrandService brandService;

    @ApiOperation(value = "通过品牌id查询品牌信息", notes = "", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResultBase<BrandDTO> get(@PathVariable @ApiParam(value = "品牌id") Long id) {
        return brandService.selectBrandById(id);
    }
}
