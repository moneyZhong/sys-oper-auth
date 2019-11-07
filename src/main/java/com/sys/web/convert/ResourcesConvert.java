package com.sys.web.convert;

import com.sys.web.controller.vo.ResourcesVO;
import com.sys.entity.ResourcesDO;

import java.util.ArrayList;
import java.util.List;

public class ResourcesConvert {

    public static ResourcesDO toResourcesDO(ResourcesVO obj){
        if(obj == null){
            return null;
        }

        ResourcesDO ret = new ResourcesDO();

        ret.setId(obj.getId());
        ret.setName(obj.getName());
        ret.setType(obj.getType());
        ret.setUrl(obj.getUrl());
        ret.setPermission(obj.getPermission());
        ret.setParentId(obj.getParentId());
        ret.setSort(obj.getSort());
        ret.setExternal(obj.getExternal());
        ret.setAvailable(obj.getAvailable());
        ret.setIcon(obj.getIcon());
        ret.setCreateTime(obj.getCreateTime());
        ret.setUpdateTime(obj.getUpdateTime());

        return ret;
    }

    public static ResourcesVO from(ResourcesDO obj){
        if(obj == null){
            return null;
        }

        ResourcesVO ret = new ResourcesVO();
        ret.setId(obj.getId());
        ret.setName(obj.getName());
        ret.setType(obj.getType());
        ret.setUrl(obj.getUrl());
        ret.setPermission(obj.getPermission());
        ret.setParentId(obj.getParentId());
        ret.setSort(obj.getSort());
        ret.setExternal(obj.getExternal());
        ret.setAvailable(obj.getAvailable());
        ret.setIcon(obj.getIcon());
        ret.setCreateTime(obj.getCreateTime());
        ret.setUpdateTime(obj.getUpdateTime());

        return ret;
    }

    public static List<ResourcesVO> from(List<ResourcesDO> list){
        if(list == null){
            return null;
        }

        List<ResourcesVO> retList = new ArrayList<>();
        for (ResourcesDO item : list) {
            retList.add(from(item));
        }

        return retList;
    }

}