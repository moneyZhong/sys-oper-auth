package com.sys.web.controller;



import com.sys.comm.response.CommonReturnType;
import com.sys.comm.util.StringUtils;
import com.sys.enums.CommonError;
import com.sys.exception.BusinessException;
import com.sys.exception.UserNotFoundException;
import com.sys.service.IMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hugx
 * @create 2018-12-30 18:36
 */
@Slf4j
public class BaseController {
    @Autowired
    private IMessageService messageService;
    /**
     * 定义exceptionHandler 解决未被controller 层处理的exception
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CommonReturnType handlerException(HttpServletRequest request, Exception ex) {
        log.error("系统异常信息：!",ex);
        log.info("ex-class:{}",ex.getClass().getName());

        int code= CommonError._100001_UNKNOWN_ERROR.getErrCode();
        String msg= CommonError._100001_UNKNOWN_ERROR.getErrMsg();
        if (ex instanceof BusinessException) {
            log.info("this is a BusinessException");

            BusinessException businessException = (BusinessException) ex;
            code=businessException.getErrCode();
            msg=businessException.getErrMsg();
        }else if(ex instanceof MethodArgumentNotValidException) {
        	//参数校验结果
	    	MethodArgumentNotValidException  argumentValidException=(MethodArgumentNotValidException)ex;
	    	BindingResult bindResult= argumentValidException.getBindingResult();
	    	String message= bindResult.getFieldError().getDefaultMessage();
	    	log.info(message);
	    	code= CommonError._100002_PARAMETER_VALIDATION_ERROR.getErrCode();
	    	msg=message;
        	 
        }else{
            messageService.sendDingDingMsg("保理服务调用异常", StringUtils.getExceptionMsg(ex));
            msg = msg + ex.getMessage();
        }
        return CommonReturnType.createFail(null,code,msg);
    }



    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public CommonReturnType formException(MethodArgumentNotValidException ex, WebRequest request) {
        log.info("调用服务参数异常", ex);
        return CommonReturnType.createFail(-1,getBindMessage(ex.getBindingResult()));
    }

    @ExceptionHandler(value = {UserNotFoundException.class})
    public CommonReturnType UserNotFoundException(UserNotFoundException ex, WebRequest request) {
        log.warn("用户信息未找到", ex);
        return CommonReturnType.createFail(-1,ex.getMessage());
    }

    private String getBindMessage(BindingResult result) {
        String message = "";
        List<FieldError> fieldErrors = result.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
//            message = fieldError.getField() + fieldError.getDefaultMessage();
            message = fieldError.getDefaultMessage();
            break;
        }
        return message;
    }
    /**
     * 设置请求分页数据
     */
//    protected <T> void  startPage(PageReq<T> pageReq)
//    {
//        PageHelper.startPage(pageReq.getPageNum(),pageReq.getPageSize());
//    }
//    /**
//     * 响应请求分页数据
//     */
//    protected <R> TableDataInfo<R> getDataTable(List<R> list)
//    {
//
//    	TableDataInfo<R> rspData = new TableDataInfo<R>();
//    	PageInfo<R> page=new PageInfo<R>(list);
//    	rspData.setPageNum(page.getPageNum());
//        rspData.setPageSize(page.getPageSize());
//        rspData.setRows(list);
//        rspData.setTotal(page.getTotal());
//        return rspData;
//    }
    
   
}
