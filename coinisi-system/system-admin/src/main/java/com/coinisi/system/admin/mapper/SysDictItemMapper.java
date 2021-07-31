package com.coinisi.system.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coinisi.system.api.entity.SysDictItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 字典数据表 Mapper 接口
 * </p>
 *
 * @author ws
 * @since 2021-05-31
 */
@Mapper
public interface SysDictItemMapper extends BaseMapper<SysDictItem> {
    List<SysDictItem> queryDictItem(SysDictItem sysDictItem);

}
