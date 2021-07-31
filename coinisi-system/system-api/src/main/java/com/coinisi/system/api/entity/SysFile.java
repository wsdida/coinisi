package com.coinisi.system.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 系统文件(SysFile)实体类
 *
 * @author makejava
 * @since 2021-07-10 17:02:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_file")
@ApiModel(value="SysFile对象", description="文件表")
public class SysFile implements Serializable {
    private static final long serialVersionUID = 823733904416565363L;
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String type;
    /**
     * 文件原名
     */
    @ApiModelProperty(value = "文件原名")
    private String name;
    /**
     * 文件现名
     */
    @ApiModelProperty(value = "文件现名")
    private String currentName;
    /**
     * 文件存储路径
     */
    @ApiModelProperty(value = "文件存储路径")
    private String url;
    /**
     * 文件大小文件存储路径
     */
    @ApiModelProperty(value = "文件大小")
    private Double size;
    /**
     *
     */
    @ApiModelProperty(value = "1已删除2未删除")
    private Object isDelete;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;


}
