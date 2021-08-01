package com.coinisi.system.api.vo;

import com.coinisi.system.api.entity.SysUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserVO extends SysUser {
    @ApiModelProperty(value = "部门名称")
    private String deptName;
    @ApiModelProperty(value = "key")
    private Long  key;
}
