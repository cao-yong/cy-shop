package com.caoyong.programs.service.impl;

import com.caoyong.base.bean.ResultBase;
import com.caoyong.commons.enums.ErrorCodeEnum;
import com.caoyong.programs.service.ShopService;
import com.caoyong.yzb.bean.Shop;
import com.caoyong.yzb.bean.dto.ShopDTO;
import com.caoyong.yzb.dao.ShopDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 品牌管理
 *
 * @author yong.cao
 * @time 2017年6月10日下午1:41:42
 */

@Transactional(rollbackFor = Exception.class)
@Slf4j
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    public ResultBase<ShopDTO> selectShopById(Long id) {
        ResultBase<ShopDTO> result = new ResultBase<>();
        Shop shop;
        try {
            shop = shopDao.selectByPrimaryKey(id);
            if (null != shop) {
                ShopDTO shopDTO = new ShopDTO();
                BeanUtils.copyProperties(shop, shopDTO);
                result.setValue(shopDTO);
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setErrorCode(ErrorCodeEnum.UNKNOWN_ERROR.getCode());
            result.setErrorCode(ErrorCodeEnum.UNKNOWN_ERROR.getMsg());
            log.error("selectShopById Exception:{}", e.getMessage(), e);
        }
        return result;
    }

}
