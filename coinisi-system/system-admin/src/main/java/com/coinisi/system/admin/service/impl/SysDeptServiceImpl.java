package com.coinisi.system.admin.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coinisi.system.admin.mapper.SysDeptMapper;
import com.coinisi.system.admin.service.ISysDeptService;
import com.coinisi.system.api.entity.SysDept;
import com.coinisi.system.api.vo.SysDeptVo;
import com.coinisi.system.api.vo.SysSelectTreeVo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author ws
 * @since 2021-05-3
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {
    /**
     * 查询部门树形结构
     *
     * @return
     */
    @Override
    public List<SysDeptVo> treeDept(SysDeptVo sysDeptVo) {

        List<SysDeptVo> deptVoList=  baseMapper.treeDept(sysDeptVo);
        AtomicBoolean childer = new AtomicBoolean(false);
        deptVoList.stream().forEach(item ->{
            if(0 == item.getParentId()){
                childer.set(true);
            }
        });
        if(childer.get()){
            return   deptVoList.stream().filter(item ->0 == item.getParentId()).map(item -> {
                item.setChildren(getChildren(item,deptVoList));
                return item;
            }).collect(Collectors.toList());

        }else{
            return deptVoList;
        }

    }

    /**
     * 查询部门下拉使用
     */
    @Override
    public List<SysSelectTreeVo> treeDeptVo() {
        List<SysSelectTreeVo> treeDeptVo=baseMapper.treeDeptVo();
        return treeDeptVo.stream().filter(item ->"0".equals(item.getParentId())  ).map(item -> {
            item.setChildren(getChildrenDept(item,treeDeptVo));
            return item;
        }).collect(Collectors.toList());
    }
    public static List<SysSelectTreeVo> getChildrenDept(SysSelectTreeVo sysDeptVo, List<SysSelectTreeVo> voList){
        List<SysSelectTreeVo> s=voList.stream().filter(item -> item.getParentId().toString().equals(sysDeptVo.getValue())).map(item ->{
            item.setChildren(getChildrenDept(item,voList));
            return item;
        }).collect(Collectors.toList());
        return s;
    }
    public static List<SysDeptVo> getChildren(SysDeptVo sysDeptVo, List<SysDeptVo> voList){
        List<SysDeptVo> s=voList.stream().filter(item -> Long.parseLong(item.getParentId().toString()) ==sysDeptVo.getId()).map(item ->{
            item.setChildren(getChildren(item,voList));
            return item;
        }).collect(Collectors.toList());
        return s;
    }
}
