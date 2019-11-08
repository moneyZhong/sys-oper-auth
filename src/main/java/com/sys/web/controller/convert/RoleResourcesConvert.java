package com.sys.web.controller.convert;

import com.sys.web.controller.vo.RoleResourcesVO;
import com.sys.entity.RoleResourcesDO;

import java.util.ArrayList;
import java.util.List;

public class RoleResourcesConvert {

    public static RoleResourcesDO toRoleResourcesDO(RoleResourcesVO obj){
        if(obj == null){
            return null;
        }

        RoleResourcesDO ret = new RoleResourcesDO();

        ret.setId(obj.getId());
        ret.setRoleId(obj.getRoleId());
        ret.setResourcesId(obj.getResourcesId());
        ret.setCreateTime(obj.getCreateTime());
        ret.setUpdateTime(obj.getUpdateTime());

        return ret;
    }

    public static RoleResourcesVO from(RoleResourcesDO obj){
        if(obj == null){
            return null;
        }

        RoleResourcesVO ret = new RoleResourcesVO();
        ret.setId(obj.getId());
        ret.setRoleId(obj.getRoleId());
        ret.setResourcesId(obj.getResourcesId());
        ret.setCreateTime(obj.getCreateTime());
        ret.setUpdateTime(obj.getUpdateTime());

        return ret;
    }

    public static List<RoleResourcesVO> from(List<RoleResourcesDO> list){
        if(list == null){
            return null;
        }

        List<RoleResourcesVO> retList = new ArrayList<>();
        for (RoleResourcesDO item : list) {
            retList.add(from(item));
        }

        return retList;
    }

}