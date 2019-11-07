package com.sys.exception;

import com.sys.enums.CommonError;
import lombok.Data;

/**
 * 包装器业务异常类实现

 */
@Data
public class BusinessException extends RuntimeException {

    private CommonError commonError;

    private Integer errCode;

    private String errMsg;

    /**
     *   直接接收EmBusinessError 的传参用于构造业务异常
     */
    public BusinessException(CommonError commonError) {
        super(commonError.getErrCode()+"-"+commonError.getErrMsg());
        this.commonError = commonError;
        this.errCode = commonError.getErrCode();
        this.errMsg = commonError.getErrMsg();
    }

    /**
     * 接收自定义errMsg的方式构造业务异常
     * @param commonError
     * @param errMsg
     */
    public BusinessException(CommonError commonError, String errMsg) {
        super();
        this.errCode = commonError.getErrCode();
        this.errMsg = errMsg;
    }

    /**
     * 接收自定义带参数errMsg的方式构造业务异常
     * @param commonError
     * @param errMsg
     */
    public BusinessException(CommonError commonError, String errMsg, Object... args) {
        super();
        this.errCode = commonError.getErrCode();
        this.errMsg = String.format(errMsg,args);
    }

    private BusinessException(int errCode, String errMsg) {
        super();
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    /**
     *   直接接收EmBusinessError 的传参用于构造业务异常
     */
    public static BusinessException getInstance(CommonError commonError) {
        return new BusinessException(commonError);
    }

    /**
     *   直接接收EmBusinessError 的传参用于构造业务异常
     */
    public static BusinessException getInstance(CommonError commonError, String errMsg) {
        return new BusinessException(commonError.getErrCode(),errMsg);
    }

    public Integer getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

}
