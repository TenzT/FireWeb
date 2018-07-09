package com.fireengineering.management.service.impl;

import com.fireengineering.management.mapper.FiresystemMapper;
import com.fireengineering.management.po.Firesystem;
import com.fireengineering.management.po.FiresystemExample;
import com.fireengineering.management.service.FiresystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FiresystemServiceImpl implements FiresystemService {

    @Autowired
    FiresystemMapper firesystemMapper;
    //删
    public int deleteFiresystemById(Integer firesystemId) {
        return firesystemMapper.deleteByPrimaryKey(firesystemId);
    }

    //改
    public int updateFiresystemById(Firesystem firesystem) {
        return firesystemMapper.updateByPrimaryKey(firesystem);
    }

    //查
    public List<Firesystem> getFiresystemList(Integer offset, Integer limit) {
        return firesystemMapper.selectByLimitAndOffset(offset,limit);
    }

    public List<Firesystem> getAllFiresystem() {
        FiresystemExample example = new FiresystemExample();
        return firesystemMapper.selectByExample(example);
    }

    public int getFiresystemCount() {
        FiresystemExample example = new FiresystemExample();
        return firesystemMapper.countByExample(example);
    }

    public Firesystem getFiresystemByName(String firesystemName) {
        return firesystemMapper.selectByName(firesystemName);
    }

    public Firesystem getFiresystemById(Integer firesystemId) {
        return firesystemMapper.selectByPrimaryKey(firesystemId);
    }

    //增
    public int addFiresystem(Firesystem fireSystem) {
        return firesystemMapper.insert(fireSystem);
    }
    

}
