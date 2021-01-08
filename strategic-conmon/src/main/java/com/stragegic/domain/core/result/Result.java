package com.stragegic.domain.core.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code = 0;
    private String msg = "ok";
    private T data;

    public static <T>Result<T> ok(T data) {
       Result<T> result = new Result<>();
        result.setData(data);
        return result;
    }

    public static Result ok() {
        return new Result();
    }

    public static Result error(String message, int code) {
     Result result = new Result();
        result.setMsg(message);
        result.setCode(code);
        return result;
    }

    @JsonIgnore
    public boolean isOk() {
        return this.code == 0;
    }
}