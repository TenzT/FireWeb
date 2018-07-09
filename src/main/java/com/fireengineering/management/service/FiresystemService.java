package com.fireengineering.management.service;

import com.fireengineering.management.po.Firesystem;

import java.util.List;

public interface FiresystemService {

    //删
    public int deleteFiresystemById(Integer firesystemId);

    //改
    public int updateFiresystemById(Firesystem firesystem);

    //查
    public List<Firesystem> getFiresystemList(Integer offset, Integer limit);

    public List<Firesystem> getAllFiresystem();

    public int getFiresystemCount();

    public Firesystem getFiresystemByName(String firesystemName);

    public Firesystem getFiresystemById(Integer firesystemId);

    //增
    public int addFiresystem(Firesystem fireSystem);


}
