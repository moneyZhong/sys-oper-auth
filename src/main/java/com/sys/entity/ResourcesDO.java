package com.sys.entity;

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
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_resources")
@ApiModel(value="ResourcesDO对象", description="")
public class ResourcesDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @ApiModelProperty(value = "menu 菜单 button 按钮")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "菜单地址")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "资源名称")
    @TableField("permission")
    private String permission;

    @ApiModelProperty(value = "父节点")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "用户排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "是否外部链接")
    @TableField("external")
    private Boolean external;

    @ApiModelProperty(value = "是否有效 0 无效 1 有效")
    @TableField("available")
    private Boolean available;

    @ApiModelProperty(value = "菜单图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "添加时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String TYPE = "type";

    public static final String URL = "url";

    public static final String PERMISSION = "permission";

    public static final String PARENT_ID = "parent_id";

    public static final String SORT = "sort";

    public static final String EXTERNAL = "external";

    public static final String AVAILABLE = "available";

    public static final String ICON = "icon";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

}
