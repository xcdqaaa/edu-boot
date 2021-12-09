package com.aaa.edu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共返回对象
 *
 * @author zhoubin
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object data;

    /**
     * 成功返回结果
     *
     * @param message
     * @return
     */
    public static RespBean success(String message) {
        return new RespBean(200, message, null);
    }
//    public static RespBean success(Object obj) {
//        return new RespBean(200, null, null);
//    }

    /**
     * 成功返回结果
     *
     * @param message
     * @param data
     * @return
     */
    public static RespBean success(String message, Object data) {
        return new RespBean(200, message,data);
    }

    /**
     * 失败返回结果
     *
     * @param message
     * @return
     */
    public static RespBean error(String message) {
        return new RespBean(500, message, null);
    }

    /**
     * 失败返回结果
     *
     * @param message
     * @param data
     * @return
     */
    public static RespBean error(String message, Object data) {
        return new RespBean(500, message, data);
    }
}