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
public class RoleResourcesVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;


    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    private Long roleId;


    /**
     * 资源ID
     */
    @ApiModelProperty(value = "资源ID")
    private Long resourcesId;


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
