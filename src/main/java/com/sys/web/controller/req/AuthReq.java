package com.sys.web.controller.req;

import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class AuthReq {
    @ApiParam
    private String userName;
    private String passWord;
    private Boolean rememberMe;
}
