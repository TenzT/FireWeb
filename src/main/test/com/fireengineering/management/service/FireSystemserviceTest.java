package com.fireengineering.management.service;

import com.fireengineering.management.po.Firesystem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-**.xml"})
public class FireSystemserviceTest {
    @Autowired
    FiresystemService firesystemService;

    @Test
    public void deleteFireSystemById() {
        firesystemService.deleteFiresystemById(4);
    }

    @Test
    public void updateFiresystemById() {
        Firesystem firesystem = new Firesystem();
        firesystem.setId(5);
        firesystem.setName("消防供电");
        firesystemService.updateFiresystemById(firesystem);
    }

    @Test
    public void getFiresystemList() {
        List<Firesystem> list = firesystemService.getFiresystemList(0,5);
        for(Firesystem f:list) {
            System.out.println(f);
        }
    }

    @Test
    public void getAllFiresystemByName() {
        List<Firesystem> list = firesystemService.getAllFiresystem();
        for(Firesystem f:list) {
            System.out.println(f);
        }
    }


    @Test
    public void getFireSystemCount() {
        System.out.println(firesystemService.getFiresystemCount());
    }

    @Test
    public void addFireSystem() {
        Firesystem firesystem = new Firesystem();
        firesystem.setName("消防供电配电");
        firesystemService.addFiresystem(firesystem);
    }

    @Test
    public void getFiresystemByName() {
        System.out.println(firesystemService.getFiresystemByName("消防供电").getName());
    }
}