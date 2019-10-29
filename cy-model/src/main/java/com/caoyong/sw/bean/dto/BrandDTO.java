package com.caoyong.sw.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class BrandDTO implements Serializable {
    private static final long serialVersionUID = -2734620387467007263L;

    @ApiModelProperty(value = "品牌id")
    private Integer brandId;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "品牌图片url")
    private String brandImg;

    @ApiModelProperty(value = "品牌路径")
    private String brandUrl;

    private Date createTime;

    /**
     * 一档价格折扣
     */
    private BigDecimal price1;

    /**
     * 二档价格折扣
     */
    private BigDecimal price2;

    /**
     * 三档价格折扣
     */
    private BigDecimal price3;

    /**
     * 四档价格折扣
     */
    private BigDecimal price4;

    /**
     * 五档价格折扣
     */
    private BigDecimal price5;
    /**
     * 六档价格折扣
     */
    private BigDecimal price6;

    private String price7;
    /**
     * 四档价格
     */
    private Integer brandState;

    private Integer isDelete;

    private Integer sort;

    private String brandDesc;

    private String brandDescImg;

    private Date lastUpdateTime;

    private BigDecimal discount;
    /**
     * 积分比率
     */
    private BigDecimal integralRate;

    private String acronym;

    private Integer recommendOther;

    private BigDecimal price8;

    private BigDecimal price9;

    private BigDecimal price10;

    private BigDecimal price11;

    private BigDecimal price12;

    private BigDecimal price13;

    private BigDecimal price14;

    private BigDecimal price15;

    private BigDecimal price16;

    private BigDecimal price17;

    private BigDecimal price18;

    private BigDecimal price19;

    private BigDecimal price20;

    private BigDecimal price21;

    private BigDecimal price22;

    private BigDecimal price23;

    private BigDecimal price24;

    private BigDecimal price25;

    private BigDecimal price26;

    private BigDecimal price27;

    private BigDecimal price28;

    private BigDecimal price29;

    private BigDecimal price30;
}