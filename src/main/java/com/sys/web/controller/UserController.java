package com.sys.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.java.Log;
import com.sys.comm.response.CommonReturnType;
import com.sys.controller.convert.*;
import com.sys.controller.vo.*;
import com.sys.entity.*;
import com.sys.service.*;
import java.util.*;

/*
user-do
userDO
UserController
userDO
*/


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhongqian
 * @since 2019-11-07
 */
@Log
@Api(value = "", description="")
@RestController
@RequestMapping("//user")
public class UserController  extends BaseController{
    @Autowired
    private UserService userService;

    /**
     * 保存
     */
    @ApiOperation(value = "保存", httpMethod = "POST")
    @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
    @PostMapping(value="/save")
    public CommonReturnType<Object> add(@RequestBody UserVO inputVO) {
        CommonReturnType<Object> ret = null;

        this.userService.saveOrUpdate(inputVO);

        ret = CommonReturnType.createSuccess(null);
        return ret;
    }


    /**
     * 详情
     */
/*
    @ApiOperation(value = "详情", httpMethod = "POST")
    @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
    @PostMapping(value="/view/{id}")
    public CommonReturnType<UserVO> view(@PathVariable Long id) {
        CommonReturnType<UserVO> ret = null;

        final UserDO doObj = this.userService.getById(id);
        final UserVO voObj = UserConvert.from(doObj);

        ret = CommonReturnType.createSuccess(voObj);

        return ret;
    }*/

    /**
     * 分页列表
     */
    /*
    @ApiOperation(value = "分页列表", httpMethod = "POST")
    @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
    @PostMapping(value="/list")
    public CommonReturnType<UserVO> list(@RequestBody UserVO inputVO) {
        CommonReturnType<UserVO> ret = null;
        final UserVO demoVO = new UserVO();
        ret = CommonReturnType.createSuccess(demoVO);
        return ret;
    }*/


    /**
     * 查询列表
     */
    @ApiOperation(value = "查询列表", httpMethod = "POST")
    @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
    @PostMapping(value="/list")
    public CommonReturnType<List<UserVO>> list(@RequestBody RecordReqVO inputVO) {
        CommonReturnType<List<UserVO>> ret = null;

        final List<UserDO> doList = this.userService.list();
        List<UserVO> list = UserConvert.from(doList);

        ret = CommonReturnType.createSuccess(list);

        return ret;
    }

}
