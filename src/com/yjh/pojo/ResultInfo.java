/**
 * @no 3207130137
 * @author 叶嘉豪
 */
package com.yjh.pojo;

/**
 * 返回状态
 */
public class ResultInfo {
    /**
     * 操作代码
     */
    private Integer code = 200;
    /**
     * 操作信息
     */
    private String msg = "操作成功";
    /**
     * 操作结果
     */
    private Object result;

    //无参构造方法
    public ResultInfo() {
    }

    //全参构造方法
    public ResultInfo(Integer code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
