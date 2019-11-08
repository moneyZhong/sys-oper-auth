package com.sys.web.controller.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2019-11-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

@ApiModel("")
public class ResourcesVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;



    private String name;


    /**
     * menu 菜单 button 按钮
     */
    @ApiModelProperty(value = "menu 菜单 button 按钮")
    private String type;


    /**
     * 菜单地址
     */
    @ApiModelProperty(value = "菜单地址")
    private String url;


    /**
     * 资源名称
     */
    @ApiModelProperty(value = "资源名称")
    private String permission;


    /**
     * 父节点
     */
    @ApiModelProperty(value = "父节点")
    private Long parentId;


    /**
     * 用户排序
     */
    @ApiModelProperty(value = "用户排序")
    private Integer sort;


    /**
     * 是否外部链接
     */
    @ApiModelProperty(value = "是否外部链接")
    private Boolean external;


    /**
     * 是否有效 0 无效 1 有效
     */
    @ApiModelProperty(value = "是否有效 0 无效 1 有效")
    private Boolean available;


    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标")
    private String icon;


    /**
     * 添加时间
     */
    @ApiModelProperty(value = "添加时间")
    private LocalDateTime createTime;


    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;



}
