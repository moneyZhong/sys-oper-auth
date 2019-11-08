package com.sys.web.controller.convert;

import com.sys.web.controller.vo.UserRoleVO;
import com.sys.entity.UserRoleDO;

import java.util.ArrayList;
import java.util.List;

public class UserRoleConvert {

    public static UserRoleDO toUserRoleDO(UserRoleVO obj){
        if(obj == null){
            return null;
        }

        UserRoleDO ret = new UserRoleDO();

        ret.setId(obj.getId());
        ret.setUserId(obj.getUserId());
        ret.setRoleId(obj.getRoleId());
        ret.setCreateTime(obj.getCreateTime());
        ret.setUpdateTime(obj.getUpdateTime());

        return ret;
    }

    public static UserRoleVO from(UserRoleDO obj){
        if(obj == null){
            return null;
        }

        UserRoleVO ret = new UserRoleVO();
        ret.setId(obj.getId());
        ret.setUserId(obj.getUserId());
        ret.setRoleId(obj.getRoleId());
        ret.setCreateTime(obj.getCreateTime());
        ret.setUpdateTime(obj.getUpdateTime());

        return ret;
    }

    public static List<UserRoleVO> from(List<UserRoleDO> list){
        if(list == null){
            return null;
        }

        List<UserRoleVO> retList = new ArrayList<>();
        for (UserRoleDO item : list) {
            retList.add(from(item));
        }

        return retList;
    }

}