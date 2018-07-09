package com.fireengineering.management.service;

import com.fireengineering.management.po.Firesystem;

import java.util.List;

public interface FireSystemService {

    //删
    public int deleteFireSystemById(Integer firesystemId);

    //改
    public int updateFireSystemById(Firesystem firesystem);

    //查
    public List<Firesystem> getAllFireSystem();

    public Firesystem getFireSystemByName(String fireSystemName);

    public Firesystem getFireSystemById(Integer firesystemId);


    //增
    public int addFireSystem(Firesystem fireSystem);



}
