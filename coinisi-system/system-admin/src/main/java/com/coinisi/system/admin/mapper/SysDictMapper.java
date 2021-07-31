package com.coinisi.system.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coinisi.system.api.entity.SysDict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Mapper
public interface SysDictMapper extends BaseMapper<SysDict> {
    /**
     * 查询字典类型表
     * @param sysDict
     * @return
     */
    List<SysDict> queryDictList(SysDict sysDict);

}
