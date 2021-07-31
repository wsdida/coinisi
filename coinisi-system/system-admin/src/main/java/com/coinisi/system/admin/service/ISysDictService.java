package com.coinisi.system.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.coinisi.system.api.entity.SysDict;

import java.util.List;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
public interface ISysDictService extends IService<SysDict> {

    /**
     * 查询字典类型
     * @param sysDict
     * @return
     */
    List<SysDict> queryDictList(SysDict sysDict);

}
