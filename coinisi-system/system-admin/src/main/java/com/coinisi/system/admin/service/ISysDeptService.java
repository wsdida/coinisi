package com.coinisi.system.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coinisi.system.api.entity.SysDept;
import com.coinisi.system.api.vo.SysDeptVo;
import com.coinisi.system.api.vo.SysSelectTreeVo;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
public interface ISysDeptService extends IService<SysDept> {

    /**
     * 查询部门树形结构
     * @return
     */
   List<SysDeptVo> treeDept(SysDeptVo sysDeptVo);

    /**
     * 查询部门下拉使用
     */
    List<SysSelectTreeVo> treeDeptVo();

}
