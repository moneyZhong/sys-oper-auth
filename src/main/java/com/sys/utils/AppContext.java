package com.sys.utils;

import lombok.Setter;

/**
 * 应用上下文
 */
public class AppContext {


    @Setter
    private Long userId;
    @Setter
    private String realName;


 
    private static ThreadLocal<AppContext> appContextThreadLocal = new ThreadLocal<>();



    
    public static void addUserId(Long id) {
        if(appContextThreadLocal == null){
            appContextThreadLocal = new ThreadLocal<>();
        }
        AppContext appContext = appContextThreadLocal.get();
        if(appContext == null){
            appContext = new AppContext();
        }
        appContext.setUserId(id);
        appContextThreadLocal.set(appContext);
    }

    public static void addRealName(String realName) {
        if(appContextThreadLocal == null){
            appContextThreadLocal = new ThreadLocal<>();
        }
        AppContext appContext = appContextThreadLocal.get();
        if(appContext == null){
            appContext = new AppContext();
        }
        appContext.setRealName(realName);
        appContextThreadLocal.set(appContext);
    }

    public static AppContext getInstance(){
        return appContextThreadLocal.get();
    }
 
    public static Long getUserId() {
        AppContext appContext = getInstance();
        if(appContext == null){
            return null;
        }
        return appContext.userId;
    }
    public static String getRealName() {
        AppContext appContext = getInstance();
        if(appContext == null){
            return null;
        }
        return appContext.realName;
    }
 
    public static void remove() {
        appContextThreadLocal.remove();
    }
    
}
