package com.springboot.start.response;

/**
 * @Author liuxian
 * @Date 2018/6/5
 * @Desc
 */
public class CustomResponse<T> extends BaseResponse {
    private T data;

    public CustomResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public static CustomResponse<String> empty() {
        return new CustomResponse("暂无数据");
    }
}
