package com.caoyong.product.controller;

import com.caoyong.base.bean.ResultBase;
import com.caoyong.product.service.BrandService;
import com.caoyong.sw.bean.dto.BrandDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
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
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private Registration registration;
    @Autowired
    private DiscoveryClient client;
    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResultBase<BrandDTO> selectBrandById(@PathVariable Long id) {
        client.getInstances(registration.getServiceId()).stream().filter(item -> 20000 == item.getPort()).findFirst().ifPresent(instance -> log.info("brand, method: get, host:" + instance.getHost() + ", serviceId:" + instance.getServiceId() + ",brandId: " + id));
        return brandService.selectBrandById(id);
    }

}
