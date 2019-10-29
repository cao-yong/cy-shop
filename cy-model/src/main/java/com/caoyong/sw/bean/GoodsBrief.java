package com.caoyong.sw.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "tst_goods_brief")
public class GoodsBrief implements Serializable {
    @Id
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 表示分类属于第几层
     */
    private Integer layer;

    @Column(name = "merchants_id")
    private Integer merchantsId;

    @Column(name = "goods_storehouse")
    private String goodsStorehouse;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_sku")
    private String goodsSku;

    @Column(name = "goods_cas")
    private String goodsCas;

    @Column(name = "goods_img")
    private String goodsImg;

    private Integer version;
}