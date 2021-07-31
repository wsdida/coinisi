package com.coinisi.system.admin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.system.admin.mapper.SysDictMapper;
import com.coinisi.system.admin.service.ISysDictService;
import com.coinisi.system.api.entity.SysDict;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {

    /**
     * 查询字典类型
     *
     * @param sysDict
     * @return
     */
    @Override
    public List<SysDict> queryDictList(SysDict sysDict) {
        return baseMapper.queryDictList(sysDict);
    }
}
