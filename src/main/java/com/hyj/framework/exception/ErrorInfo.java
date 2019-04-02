package com.hyj.framework.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liwj0 on 2017/7/19.
 */
public enum ErrorInfo {
    NO_LOGIN(10001, "登录失效，请重新登录"),
    LOGIN_ERROR(10002, "权限不足或登录失效"),
    PARAMS_ERROR(10003, "参数错误"),
    SERVER_ERROR(10004, "程序内部错误"),

    ;


    public final String desc;
    public final int code;
    // 构造方法
    private ErrorInfo(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    private static Map<Integer,ErrorInfo> map;
    static {
        ErrorInfo[] res = values();
        map = new HashMap<>(res.length);
        for(ErrorInfo tmp: res) {
            map.put(tmp.code, tmp);
        }
    }

    public static ErrorInfo getByCode(int code){
        return map.get(code);
    }

    public static String getMsgByCode(int code){
        return map.get(code).desc;
    }
}
