package com.caoyong.product.service.impl;

import com.caoyong.base.bean.ResultBase;
import com.caoyong.commons.enums.ErrorCodeEnum;
import com.caoyong.product.service.BrandService;
import com.caoyong.sw.bean.Brand;
import com.caoyong.sw.bean.dto.BrandDTO;
import com.caoyong.sw.dao.BrandDao;
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
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    @Override
    public ResultBase<BrandDTO> selectBrandById(Long id) {
        ResultBase<BrandDTO> result = new ResultBase<>();
        Brand brand;
        try {
            brand = brandDao.selectByPrimaryKey(id);
            if (null != brand) {
                BrandDTO brandDTO = new BrandDTO();
                BeanUtils.copyProperties(brand, brandDTO);
                result.setValue(brandDTO);
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setErrorCode(ErrorCodeEnum.UNKNOWN_ERROR.getCode());
            result.setErrorCode(ErrorCodeEnum.UNKNOWN_ERROR.getMsg());
            log.error("selectBrandById Exception:{}", e.getMessage(), e);
        }
        return result;
    }

}
