/****************************************
 * Copyright (c) 2019 G7.
 * All rights reserved.
 * Created on 2019-05-22
 * 
 * Contributors:
 * 	   Michael Luo - initial implementation
 ****************************************/

package com.sys.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * SpringContext.java
 */
@Component
public class SpringContext implements ApplicationContextAware {

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx =ctx;
    }

    public Object getBean(String name) {
        return ctx.getBean(name);
    }

    public <T> T getBean(String name, Class<T> clazz) {
        return ctx.getBean(name, clazz);
    }
}
