package com.coinisi.system.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.coinisi.system.api.entity.SysDictItem;

import java.util.List;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
public interface ISysDictItemService extends IService<SysDictItem> {
    /**
     * 查询字典列表
     * @param sysDictItem
     * @return
     */
    List<SysDictItem> queryDictItem(SysDictItem sysDictItem);
}
