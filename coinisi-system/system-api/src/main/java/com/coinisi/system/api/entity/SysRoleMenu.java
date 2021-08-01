package com.coinisi.system.api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.bytebuddy.utility.JavaType;

/**
 * <p>
 * 角色和菜单关联表
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role_menu")
@ApiModel(value="SysRoleMenu对象", description="角色和菜单关联表")
public class SysRoleMenu implements Serializable {



    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    @ApiModelProperty(value = "角色ID")
    @TableField
    private String roleId;

    @ApiModelProperty(value = "菜单ID")
    @TableField
    private String menuId;


}
