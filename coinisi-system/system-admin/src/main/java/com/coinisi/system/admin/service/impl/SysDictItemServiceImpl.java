package com.coinisi.system.admin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.system.admin.mapper.SysDictItemMapper;
import com.coinisi.system.admin.service.ISysDictItemService;
import com.coinisi.system.api.entity.SysDictItem;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Service
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemMapper, SysDictItem> implements ISysDictItemService {

    /**
     * 查询字典列表
     *
     * @param sysDictItem
     * @return
     */
    @Override
    public List<SysDictItem> queryDictItem(SysDictItem sysDictItem) {
        return baseMapper.queryDictItem(sysDictItem);
    }
}
