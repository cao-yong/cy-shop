
package com.caoyong.yzb.bean.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShopDTO implements Serializable {
    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 店铺名字
     */
    private String name;

    /**
     * 店铺签名
     */
    private String phone;

    /**
     * 店铺地址
     */
    private String address;

    /**
     * 地区编码（绑定站点）
     */
    private String areaCode;

    /**
     * 站点信息审核 0-审核中，1-审核通过，2-审核失败
     */
    private Integer areaAudit;

    /**
     * 代理等级 1-一级， 2-二级
     */
    private Integer shopLevel;

    /**
     * 联系号码
     */
    private String phoneNumber;

    /**
     * 微信号码
     */
    private String wechatNumber;

    /**
     * logo
     */
    private String logo;

    /**
     * 维度
     */
    private String lat;

    /**
     * 经度
     */
    private String lon;

    /**
     * 【空字段】
     */
    private Integer state;

    /**
     * 【空字段】
     */
    private Integer audit;

    /**
     * 审核意见
     */
    private String auditCount;

    /**
     * 是否开启本地专场【0=否，1=是】
     */
    private Integer yesNo;

    /**
     * 数量限制最多多少个品牌
     */
    private Integer number;

    /**
     * 最小金额
     */
    private String smallPrice;

    /**
     * 最大金额
     */
    private String maxPrice;

}