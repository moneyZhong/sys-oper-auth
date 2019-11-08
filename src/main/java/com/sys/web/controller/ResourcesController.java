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
resources-do
resourcesDO
ResourcesController
resourcesDO
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
@RequestMapping("//resources")
public class ResourcesController  extends BaseController{
    @Autowired
    private ResourcesService resourcesService;

    /**
     * 保存
     */
    @ApiOperation(value = "保存", httpMethod = "POST")
    @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
    @PostMapping(value="/save")
    public CommonReturnType<Object> add(@RequestBody ResourcesVO inputVO) {
        CommonReturnType<Object> ret = null;

        this.resourcesService.saveOrUpdate(ResourcesConvert.toResourcesDO(inputVO));

        ret = CommonReturnType.createSuccess(null);
        return ret;
    }


    /**
     * 详情
     */

    @ApiOperation(value = "详情", httpMethod = "POST")
    @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
    @PostMapping(value="/view/{id}")
    public CommonReturnType<ResourcesVO> view(@PathVariable Long id) {
        CommonReturnType<ResourcesVO> ret = null;

        final ResourcesDO doObj = this.resourcesService.getById(id);
        final ResourcesVO voObj = ResourcesConvert.from(doObj);

        ret = CommonReturnType.createSuccess(voObj);

        return ret;
    }

        /**
        * 分页列表
        */
 /*       @ApiOperation(value = "分页列表", httpMethod = "POST")
        @ApiResponse(code = 200, message = "success", response = CommonReturnType.class)
        @PostMapping(value="/list")
        public CommonReturnType<TableDataInfo<ResourcesVO>> list(@RequestBody PageReq<ResourcesVO> inputVO) {
            TableDataInfo<ResourcesVO> tableDataInfo = this.resourcesService.selectPage(inputVO.getData());
            ret = CommonReturnType.createSuccess(demoVO);
            return ret;
        }
*/



}
