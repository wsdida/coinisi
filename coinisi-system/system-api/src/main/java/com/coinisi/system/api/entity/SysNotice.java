package com.coinisi.system.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 通知公告对象 sys_notice
 * 
 * @author ruoyi
 * @date 2021-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_notice")
@ApiModel(value="SysDept对象", description="部门表")
public class SysNotice
{
    private static final long serialVersionUID = 1L;

    /** 公告ID */
    private Integer id;

    /** 公告标题 */
    @ApiModelProperty(value = "公告标题")
    private String noticeTitle;

    /** 公告类型（1通
     * 知 2公告） */
    @ApiModelProperty(value = "公告类型")
    private String noticeType;

    /** 公告内容 */
    @ApiModelProperty(value = "公告内容")
    private String noticeContent;

    /** 公告状态（0正常 1关闭） */
    @ApiModelProperty(value = "公告状态")
    private String status;
    private String createUser;
    private Date createTime;
    private String updateUser;
    private Date updateTime;
    private Integer deleted;
  private String remark;

}
