package com.sys.web.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhongqian
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

@ApiModel("")
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;



    private String username;


    /**
     * 登录密码
     */
    @ApiModelProperty(value = "登录密码")
    private String password;


    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickname;


    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;


    /**
     * 邮箱地址
     */
    @ApiModelProperty(value = "邮箱地址")
    private String email;


    /**
     * QQ
     */
    @ApiModelProperty(value = "QQ")
    private String qq;


    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    private LocalDate birthday;


    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Integer gender;


    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址")
    private String avatar;


    /**
     * 超级管理员、管理员、普通用户
     */
    @ApiModelProperty(value = "超级管理员、管理员、普通用户")
    private String userType;


    /**
     * 注册IP
     */
    @ApiModelProperty(value = "注册IP")
    private String regIp;


    /**
     * 最近登录IP
     */
    @ApiModelProperty(value = "最近登录IP")
    private String lastLoginIp;


    /**
     * 最近登录时间
     */
    @ApiModelProperty(value = "最近登录时间")
    private LocalDateTime lastLoginTime;


    /**
     * 登录次数
     */
    @ApiModelProperty(value = "登录次数")
    private Integer loginCount;



    /**
     * 用户状态
     */
    @ApiModelProperty(value = "用户状态")
    private Integer status;


    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间")
    private LocalDateTime createTime;


    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;



}
