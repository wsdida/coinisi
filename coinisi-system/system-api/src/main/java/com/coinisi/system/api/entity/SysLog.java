package com.coinisi.system.api.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * sys_log
 * @author 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_log")
@ApiModel(value="SysFile对象", description="日志表")
public class SysLog implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 登录地址
     */
    private String ip;

    /**
     * 登录地址
     */
    private String station;

    /**
     * 操作系统
     */
    private String system;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 状态
     */
    private String loginStatus;

    /**
     * 创建人
     */
    private Date createTime;

    /**
     * 创建时间
     */
    private Long createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private Long updateUser;

    /**
     * 业务状态
     */
    private Integer status;

    /**
     * 是否已删除
     */
    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}