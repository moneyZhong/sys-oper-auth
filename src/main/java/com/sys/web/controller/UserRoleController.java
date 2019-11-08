package com.sys.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.java.Log;
import com.sys.comm.response.CommonReturnType;
import com.sys.web.controller.convert.*;
import com.sys.web.controller.vo.*;
import com.sys.entity.*;
import com.sys.service.*;
import java.util.*;

/*
user-role-do
userRoleDO
UserRoleController
userRoleDO
*/


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhongqian
 * @since 2019-11-08
 */
@Log
@Api(value = "", description="")
@RestController
@RequestMapping("//user-role")
public class UserRoleController  extends BaseController{
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 保存
     */
    @ApiOperation(value = "保存", httpMethod = "POST")
    @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
    @PostMapping(value="/save")
    public CommonReturnType<Object> add(@RequestBody UserRoleVO inputVO) {
        CommonReturnType<Object> ret = null;

        this.userRoleService.saveOrUpdate(UserRoleConvert.toUserRoleDO(inputVO));

        ret = CommonReturnType.createSuccess(null);
        return ret;
    }


    /**
     * 详情
     */

    @ApiOperation(value = "详情", httpMethod = "POST")
    @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
    @PostMapping(value="/view/{id}")
    public CommonReturnType<UserRoleVO> view(@PathVariable Long id) {
        CommonReturnType<UserRoleVO> ret = null;

        final UserRoleDO doObj = this.userRoleService.getById(id);
        final UserRoleVO voObj = UserRoleConvert.from(doObj);

        ret = CommonReturnType.createSuccess(voObj);

        return ret;
    }

        /**
        * 分页列表
        */
 /*       @ApiOperation(value = "分页列表", httpMethod = "POST")
        @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
        @PostMapping(value="/list")
        public CommonReturnType<TableDataInfo<UserRoleVO>> list(@RequestBody PageReq<UserRoleVO> inputVO) {
            TableDataInfo<UserRoleVO> tableDataInfo = this.userRoleService.selectPage(inputVO.getData());
            ret = CommonReturnType.createSuccess(demoVO);
            return ret;
        }
*/



}
