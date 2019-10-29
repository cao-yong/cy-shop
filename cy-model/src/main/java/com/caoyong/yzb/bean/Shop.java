
package com.caoyong.yzb.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "yzb_shop")
public class Shop implements Serializable {
    /**
     * 店铺id
     */
    @Id
    @Column(name = "shop_id")
    private Integer shopId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
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
    @Column(name = "area_code")
    private String areaCode;

    /**
     * 站点信息审核 0-审核中，1-审核通过，2-审核失败
     */
    @Column(name = "area_audit")
    private Integer areaAudit;

    /**
     * 代理等级 1-一级， 2-二级
     */
    @Column(name = "shop_level")
    private Integer shopLevel;

    /**
     * 联系号码
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 微信号码
     */
    @Column(name = "wechat_number")
    private String wechatNumber;

    /**
     * logo
     */
    private String logo;

}