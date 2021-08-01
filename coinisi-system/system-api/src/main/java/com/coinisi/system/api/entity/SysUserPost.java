package com.coinisi.system.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user_post")
@ApiModel(value="SysUserPost对象", description="用户岗位表")
public class SysUserPost {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    private String userId;
    private String postid;
}
