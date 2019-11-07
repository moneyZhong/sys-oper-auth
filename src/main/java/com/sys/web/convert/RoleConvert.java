package com.sys.web.convert;

import com.sys.web.controller.vo.RoleVO;
import com.sys.entity.RoleDO;

import java.util.ArrayList;
import java.util.List;

public class RoleConvert {

    public static RoleDO toRoleDO(RoleVO obj){
        if(obj == null){
            return null;
        }

        RoleDO ret = new RoleDO();

        ret.setId(obj.getId());
        ret.setName(obj.getName());
        ret.setDescription(obj.getDescription());
        ret.setAvailable(obj.getAvailable());
        ret.setCreateTime(obj.getCreateTime());
        ret.setUpdateTime(obj.getUpdateTime());

        return ret;
    }

    public static RoleVO from(RoleDO obj){
        if(obj == null){
            return null;
        }

        RoleVO ret = new RoleVO();
        ret.setId(obj.getId());
        ret.setName(obj.getName());
        ret.setDescription(obj.getDescription());
        ret.setAvailable(obj.getAvailable());
        ret.setCreateTime(obj.getCreateTime());
        ret.setUpdateTime(obj.getUpdateTime());

        return ret;
    }

    public static List<RoleVO> from(List<RoleDO> list){
        if(list == null){
            return null;
        }

        List<RoleVO> retList = new ArrayList<>();
        for (RoleDO item : list) {
            retList.add(from(item));
        }

        return retList;
    }

}