package cash.pai.lucky.admin.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回对象
 */

@Data
public class Result<T> implements Serializable {
    /**
     * 通信数据
     */
    private T data;
    /**
     * 通信状态
     */
    private boolean flag = true;
    /**
     * 通信描述
     */
    private String msg = "";

    /**
     * 通过静态方法获取实例
     */
    public static <T> Result<T> of(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> fail() {
        return new Result<T>(false,"fail");
    }
    public static <T> Result<T> fail(String msg) {
        return new Result<T>(false,msg);
    }
    public static <T> Result<T> of(T data, boolean flag) {
        return new Result<>(data, flag);
    }

    public static <T> Result<T> of(T data, boolean flag, String msg) {
        return new Result<>(data, flag, msg);
    }

    @Deprecated
    public Result() {

    }

    private Result(T data) {
        this.data = data;
    }

    private Result(T data, boolean flag) {
        this.data = data;
        this.flag = flag;
    }

    private Result(T data, boolean flag, String msg) {
        this.data = data;
        this.flag = flag;
        this.msg = msg;
    }
    private Result(  boolean flag ,String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}
