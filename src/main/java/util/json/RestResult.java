package util.json;

import com.alibaba.fastjson.JSON;

/**
 * <p>
 *  返回前端JSON格式
 * </p>
 *
 * @author 560寝室
 * @since 2020-12-06
 */
public class RestResult {
    public void setCode(int code) {
        this.code = code;
    }

    private int code;//状态码

    private String message;//消息

    private Object data;//数据

    public RestResult setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public RestResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RestResult setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
