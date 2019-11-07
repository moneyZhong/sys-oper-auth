package com.sys.filter;

import com.alibaba.fastjson.JSONObject;

import com.sys.common.annotation.UserValid;
import com.sys.exception.UserNotFoundException;
import com.sys.utils.AppContext;
import com.sys.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.net.URLDecoder;

@Slf4j
@Component
public class UserLocalInterceptor extends HandlerInterceptorAdapter{
	@Value("${spring.profiles.active}")
	private String env;

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
    	if (handler instanceof HandlerMethod) {
    		HandlerMethod handlerMethod = (HandlerMethod) handler;  
        	Method currentMethod=handlerMethod.getMethod();
        	if(currentMethod.getAnnotation(UserValid.class)!=null){
        		return true;
        	}
        	String userId="0";
        	String realName = "";
        	String resutlt=request.getHeader(Constants.HEADER_OPERA_USERS);

        	log.info("网关传入数据：resutlt="+resutlt);
        	if(resutlt != null && !"".equals(resutlt)){
        		 String param = URLDecoder.decode(resutlt, "utf-8");
             	log.info("网关解析数据：param="+param);
             	if(param != null && !"".equals(param)){
             		JSONObject josn= JSONObject.parseObject(param);
             		String id=(String) josn.get("userId");
             		userId=id;
             		realName = josn.getString("realName");
             	}
        	}
			AppContext.addUserId(Long.parseLong(userId));
			AppContext.addRealName(realName);
    	}
    	
        return true;
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) 
            throws Exception {
    	if (handler instanceof HandlerMethod) {
    		HandlerMethod handlerMethod = (HandlerMethod) handler;  
        	Method currentMethod=handlerMethod.getMethod();
        	if(currentMethod.getAnnotation(UserValid.class)==null){
        		AppContext.remove();
        	}
    		
    	}
        return;
    }

	
}