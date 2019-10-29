package com.caoyong.base.bean;

import com.caoyong.commons.enums.ErrorCodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 返回基类
 *
 * @author caoyong
 * @since 2018年1月29日 上午11:21:45
 */
@Getter
@Setter
@ToString
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 3230910710976511975L;
    /**
     * 定义的code
     */
    @ApiModelProperty(value = "定义的code 200成功")
    private String code = ErrorCodeEnum.SUCCESS.getCode();
    /**
     * 消息
     */
    @ApiModelProperty(value = "消息")
    private String msg = ErrorCodeEnum.SUCCESS.getMsg();

    /**
     * 是否成功
     */
    @ApiModelProperty(value = "是否成功")
    private boolean isSuccess = true;

    /**
     * 结果
     */
    @ApiModelProperty(value = "结果")
    private T data;

    public BaseResponse() {
    }
}