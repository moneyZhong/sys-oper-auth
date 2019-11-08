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
role-do
roleDO
RoleController
roleDO
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
@RequestMapping("//role")
public class RoleController  extends BaseController{
    @Autowired
    private RoleService roleService;

    /**
     * 保存
     */
    @ApiOperation(value = "保存", httpMethod = "POST")
    @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
    @PostMapping(value="/save")
    public CommonReturnType<Object> add(@RequestBody RoleVO inputVO) {
        CommonReturnType<Object> ret = null;

        this.roleService.saveOrUpdate(RoleConvert.toRoleDO(inputVO));

        ret = CommonReturnType.createSuccess(null);
        return ret;
    }


    /**
     * 详情
     */

    @ApiOperation(value = "详情", httpMethod = "POST")
    @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
    @PostMapping(value="/view/{id}")
    public CommonReturnType<RoleVO> view(@PathVariable Long id) {
        CommonReturnType<RoleVO> ret = null;

        final RoleDO doObj = this.roleService.getById(id);
        final RoleVO voObj = RoleConvert.from(doObj);

        ret = CommonReturnType.createSuccess(voObj);

        return ret;
    }

        /**
        * 分页列表
        */
 /*       @ApiOperation(value = "分页列表", httpMethod = "POST")
        @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
        @PostMapping(value="/list")
        public CommonReturnType<TableDataInfo<RoleVO>> list(@RequestBody PageReq<RoleVO> inputVO) {
            TableDataInfo<RoleVO> tableDataInfo = this.roleService.selectPage(inputVO.getData());
            ret = CommonReturnType.createSuccess(demoVO);
            return ret;
        }
*/



}
