package com.coinisi.system.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coinisi.system.api.entity.SysDept;
import com.coinisi.system.api.vo.SysDeptVo;
import com.coinisi.system.api.vo.SysSelectTreeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Mapper
public interface SysDeptMapper extends BaseMapper<SysDept> {
    List<SysDeptVo> treeDept(SysDeptVo sysDeptVo);
    List<SysSelectTreeVo> treeDeptVo();
}
