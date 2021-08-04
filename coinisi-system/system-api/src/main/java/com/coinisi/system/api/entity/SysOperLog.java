package com.coinisi.system.api.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_oper_log")
@Accessors(chain = true)
@ApiModel(value = "操作日志表")
public class SysOperLog
{
    private static final long serialVersionUID = 1L;

    /** 日志主键 */
    private Long id;

    /** 模块标题 */
    @ApiModelProperty(value = "模块标题")
    private String title;

    /** 业务类型（0其它 1新增 2修改 3删除） */
    @ApiModelProperty(value = "业务类型" )
    private Integer businessType;

    /** 方法名称 */
    @ApiModelProperty(value = "方法名称")
    private String method;

    /** 请求方式 */
    @ApiModelProperty(value = "请求方式")
    private String requestMethod;

    /** 操作类别（0其它 1后台用户 2手机端用户） */
    @ApiModelProperty(value = "操作类别")
    private Integer operatorType;

    /** 操作人员 */
    @ApiModelProperty(value = "操作人员")
    private String operName;

    /** 部门名称 */
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    /** 请求URL */
    @ApiModelProperty(value = "请求URL")
    private String operUrl;

    /** 主机地址 */
    @ApiModelProperty(value = "主机地址")
    private String operIp;

    /** 操作地点 */
    @ApiModelProperty(value = "操作地点")
    private String operLocation;

    /** 请求参数 */
    @ApiModelProperty(value = "请求参数")
    private String operParam;

    /** 返回参数 */
    @ApiModelProperty(value = "返回参数")
    private String jsonResult;

    /** 操作状态（0正常 1异常） */
    @ApiModelProperty(value = "操作状态")
    private Integer status;

    /** 错误消息 */
    @ApiModelProperty(value = "错误消息")
    private String errorMsg;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "操作时间")
    private String operTime;
}
