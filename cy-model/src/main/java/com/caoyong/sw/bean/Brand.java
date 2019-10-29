package com.caoyong.sw.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Data
@Table(name = "tst_brand")
public class Brand implements Serializable {
    @Id
    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "brand_img")
    private String brandImg;

    @Column(name = "brand_url")
    private String brandUrl;

    @Column(name = "create_time")
    private Date createTime;
}