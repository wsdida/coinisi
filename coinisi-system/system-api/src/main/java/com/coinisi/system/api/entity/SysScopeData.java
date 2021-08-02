package com.coinisi.system.api.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * sys_scope_data
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_scope_data")
public class SysScopeData implements Serializable {
    /**
     * 主键1
     */
    private Long id;

    /**
     * 菜单主键
     */
    private Long menu_id;

    /**
     * 资源编号
     */
    private String resource_code;

    /**
     * 数据权限名称
     */
    private String scope_name;

    /**
     * 数据权限字段
     */
    private String scope_field;

    /**
     * 数据权限类名
     */
    private String scope_class;

    /**
     * 数据权限字段
     */
    private String scope_column;

    /**
     * 数据权限类型1
     */
    private Integer scope_type;

    /**
     * 数据权限值域
     */
    private String scope_value;

    /**
     * 数据权限备注
     */
    private String remark;

    /**
     * 创建人
     */
    private Long create_user;

    /**
     * 创建部门
     */
    private Long create_dept;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 條改人
     */
    private Long update_user;

    /**
     * 修改时间
     */
    private Date update_time;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 是否己删除
     */
    private Integer is_deleted;

    private static final long serialVersionUID = 1L;


}