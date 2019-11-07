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
role-resources-do
roleResourcesDO
RoleResourcesController
roleResourcesDO
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
@RequestMapping("//role-resources")
public class RoleResourcesController  extends BaseController{
    @Autowired
    private RoleResourcesService roleResourcesService;

    /**
     * 保存
     */
    @ApiOperation(value = "保存", httpMethod = "POST")
    @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
    @PostMapping(value="/save")
    public CommonReturnType<Object> add(@RequestBody RoleResourcesVO inputVO) {
        CommonReturnType<Object> ret = null;

        this.roleResourcesService.saveOrUpdate(inputVO);

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
    public CommonReturnType<RoleResourcesVO> view(@PathVariable Long id) {
        CommonReturnType<RoleResourcesVO> ret = null;

        final RoleResourcesDO doObj = this.roleResourcesService.getById(id);
        final RoleResourcesVO voObj = RoleResourcesConvert.from(doObj);

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
    public CommonReturnType<RoleResourcesVO> list(@RequestBody RoleResourcesVO inputVO) {
        CommonReturnType<RoleResourcesVO> ret = null;
        final RoleResourcesVO demoVO = new RoleResourcesVO();
        ret = CommonReturnType.createSuccess(demoVO);
        return ret;
    }*/


    /**
     * 查询列表
     */
    @ApiOperation(value = "查询列表", httpMethod = "POST")
    @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
    @PostMapping(value="/list")
    public CommonReturnType<List<RoleResourcesVO>> list(@RequestBody RecordReqVO inputVO) {
        CommonReturnType<List<RoleResourcesVO>> ret = null;

        final List<RoleResourcesDO> doList = this.roleResourcesService.list();
        List<RoleResourcesVO> list = RoleResourcesConvert.from(doList);

        ret = CommonReturnType.createSuccess(list);

        return ret;
    }

}
