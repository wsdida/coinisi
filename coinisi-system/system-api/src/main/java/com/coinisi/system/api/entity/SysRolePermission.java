package com.coinisi.system.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 角色权限表(SysRolePermission)实体类
 *
 * @author makejava
 * @since 2021-06-22 22:46:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role_permission")
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = 486933681032227611L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 资源id
     */
    private Long permissionId;



}
