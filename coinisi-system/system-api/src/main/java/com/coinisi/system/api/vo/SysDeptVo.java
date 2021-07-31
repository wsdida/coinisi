package com.coinisi.system.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**部门树形结构
 *
 * @author ws
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysDeptVo {
    /**
     * 主键
     */
    private Long id;
    // 部门名称
    private String name;
    // 父类id
    private Integer parentId;
    // 部门路径
    private String treePath;
    // 排序
    private Integer sort;
    private String leader;


    private String mobile;

    private String email;


    private Boolean status;


    private Boolean deleted;

    private Date gmtCreate;


    private Date gmtModified;
    private String value;

    // 子部门集合
    private List<SysDeptVo> children;
}
