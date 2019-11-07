package com.sys.web.convert;

import com.sys.web.controller.vo.UserVO;
import com.sys.entity.UserDO;

import java.util.ArrayList;
import java.util.List;

public class UserConvert {

    public static UserDO toUserDO(UserVO obj){
        if(obj == null){
            return null;
        }

        UserDO ret = new UserDO();

        ret.setId(obj.getId());
        ret.setUsername(obj.getUsername());
        ret.setPassword(obj.getPassword());
        ret.setNickname(obj.getNickname());
        ret.setMobile(obj.getMobile());
        ret.setEmail(obj.getEmail());
        ret.setQq(obj.getQq());
        ret.setBirthday(obj.getBirthday());
        ret.setGender(obj.getGender());
        ret.setAvatar(obj.getAvatar());
        ret.setUserType(obj.getUserType());
        ret.setRegIp(obj.getRegIp());
        ret.setLastLoginIp(obj.getLastLoginIp());
        ret.setLastLoginTime(obj.getLastLoginTime());
        ret.setLoginCount(obj.getLoginCount());
        ret.setStatus(obj.getStatus());
        ret.setCreateTime(obj.getCreateTime());
        ret.setUpdateTime(obj.getUpdateTime());

        return ret;
    }

    public static UserVO from(UserDO obj){
        if(obj == null){
            return null;
        }

        UserVO ret = new UserVO();
        ret.setId(obj.getId());
        ret.setUsername(obj.getUsername());
        ret.setPassword(obj.getPassword());
        ret.setNickname(obj.getNickname());
        ret.setMobile(obj.getMobile());
        ret.setEmail(obj.getEmail());
        ret.setQq(obj.getQq());
        ret.setBirthday(obj.getBirthday());
        ret.setGender(obj.getGender());
        ret.setAvatar(obj.getAvatar());
        ret.setUserType(obj.getUserType());
        ret.setRegIp(obj.getRegIp());
        ret.setLastLoginIp(obj.getLastLoginIp());
        ret.setLastLoginTime(obj.getLastLoginTime());
        ret.setLoginCount(obj.getLoginCount());
        ret.setStatus(obj.getStatus());
        ret.setCreateTime(obj.getCreateTime());
        ret.setUpdateTime(obj.getUpdateTime());

        return ret;
    }

    public static List<UserVO> from(List<UserDO> list){
        if(list == null){
            return null;
        }

        List<UserVO> retList = new ArrayList<>();
        for (UserDO item : list) {
            retList.add(from(item));
        }

        return retList;
    }

}