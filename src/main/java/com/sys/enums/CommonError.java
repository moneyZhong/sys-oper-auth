package com.sys.enums;


public enum CommonError {

    // 1000-公共异常
    /**
     * 未知错误
     */
    _100001_UNKNOWN_ERROR(100001, "未知错误"),
    /**
     * 参数不合法
     */
    _100002_PARAMETER_VALIDATION_ERROR(100002, "参数不合法"),

    /**
     * 分页处理异常
     */
    _100003_PAGEINFO_ERROR(100003, "分页处理异常"),
    /**
     * 流水号已存在,请勿重复提交
     */
    _100004_REPEAT_ERROR(100004, "流水号已存在,请勿重复提交"),
    /**
     * 数据不存在
     */
    _100005_DATA_NOT_EXISTS(100005, "数据不存在"),
    /**
     * 更新失败
     */
    _100011_UPDATE_FAILED(100011, "更新失败"),
    /**
     * 写入失败
     */
    _100012_INSERT_FAILED(100012, "写入失败"),
    /**
     * 保存失败
     */
    _100013_SAVE_FAILED(100013, "保存失败"),
    /**
     * 删除失败
     */
    _100014_DELETE_FAILED(100014, "删除失败"),

    /**
     * 加锁失败
     */
    _100015_LOCK_FAILED(100014, "加锁失败"),
    ;

    private int errCode;
    private String errMsg;

    CommonError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

}
