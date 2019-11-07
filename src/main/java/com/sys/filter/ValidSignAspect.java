package com.sys.filter;

import com.google.gson.Gson;
import com.sys.comm.response.CommonReturnType;
import com.sys.comm.util.MD5Utils;
import com.sys.comm.util.RequestBodyUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * <p>
 * 校验是否需要签名验证
 * </p>
 */
@Aspect
@Component
@Order(1)
public class ValidSignAspect{
	
	private static org.slf4j.Logger logger = LoggerFactory
			.getLogger(ValidSignAspect.class);
	
    // 配置织入点
    @Pointcut("@annotation(com.sys.common.annotation.ValidSign)")
    public void pointcut()
    {
    	
    }

   /**
     * 入参校验
     * @param joinPoint
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
    	 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
     	
    	 BufferedReader bufferedReader = request.getReader();
         String bodyStr = RequestBodyUtils.read(bufferedReader);
         logger.info(bodyStr);
         String sign=(String) request.getParameter("sign");
         String randString=(String) request.getParameter("randString");
		 String rSign= sign(randString, bodyStr,"");
         if(!rSign.equals(sign)){
    		 ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    		 HttpServletResponse response = attributes.getResponse();
             //String responseStr =dataResut.getResbody();
             String responseStr = new Gson().toJson(CommonReturnType.createFail(1001,"签名失败"));
             renderString(response, responseStr);
             return null;
    	 }
         

         Object object = joinPoint.proceed();
         return object;
    }

    public static String renderString(HttpServletResponse response, String string)
    {
        try
        {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    

	public String sign(String randString, Object req,String secret) {
			String body = MD5Utils.MD5Encode(new Gson().toJson(req), "UTF-8");
			StringBuffer str=new StringBuffer();
			str.append("randString="+randString);
			str.append("&body="+body);
			str.append("&secret="+secret);
		return MD5Utils.MD5Encode(str.toString(), "UTF-8");

	}
	
	public String  sign(String randString, String req,String secret) {
		String body = MD5Utils.MD5Encode( req, "UTF-8");
		StringBuffer str=new StringBuffer();
		str.append("randString="+randString);
		str.append("&body="+body);
		str.append("&secret="+secret);
	return MD5Utils.MD5Encode(str.toString(), "UTF-8");

}
	
}
