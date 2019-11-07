package com.sys.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 项目启动时，加载初始化数据
 */
@Slf4j
@Component
public class SysContext implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("项目启动加载.....");
    }
}
