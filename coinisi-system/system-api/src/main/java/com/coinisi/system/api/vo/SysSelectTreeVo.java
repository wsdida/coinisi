package com.coinisi.system.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysSelectTreeVo {

    public String value;
    public String title;
    public Long parentId;
    public List<SysSelectTreeVo> children;
    public List<DeptStateVo> deptStateVos;

}
@Data
@NoArgsConstructor
@AllArgsConstructor
class DeptStateVo{
    public String disabled;
    public String disableCheckbox;
    public String selectable;
    public String checkable;
}