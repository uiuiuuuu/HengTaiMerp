package com.example.hengtaimerp.vo;

import lombok.Data;


/**
 *  错误码
 * @param <T>
 */
@Data
public class DataVo<T> {
    private Integer code;
    private Long count;


    private String message;

    private T data;


    public Integer ok() {
        return  this.code = 0;

    }

    public Integer error() {
        return this.code = 1;

    }


}
