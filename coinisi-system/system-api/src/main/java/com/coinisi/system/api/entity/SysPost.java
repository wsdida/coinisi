package com.coinisi.system.api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 岗位名称
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_post")
@ApiModel(value="Syspost对象", description="角色表")
public class SysPost implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键 ")

    @TableId(value = "post_id", type = IdType.ASSIGN_ID)
    private String postId;
    @ApiModelProperty(value = "岗位编码")
    private String postCode;
    @ApiModelProperty(value = "岗位名称")
    private String postName;
    @ApiModelProperty(value = "岗位排序")
    private Integer postSort;
    @ApiModelProperty(value = "岗位状态")
    private Boolean status;
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//页面写入数据库时格式化
    @JSONField(format="yyyy-MM-dd HH:mm:ss")//数据库导出页面时json格式化
    private Date createTime;
    @ApiModelProperty(value = "创建人")
    private String updateBy;
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//页面写入数据库时格式化
    @JSONField(format="yyyy-MM-dd HH:mm:ss")//数据库导出页面时json格式化
    private Date updateTime;
    @ApiModelProperty(value = "备注")
    private String remark;
}
