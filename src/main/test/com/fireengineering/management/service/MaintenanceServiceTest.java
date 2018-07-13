package com.fireengineering.management.service;

import com.fireengineering.management.po.Maintenance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-**.xml"})
public class MaintenanceServiceTest {
    @Autowired
    MaintenanceService maintenanceService;

    @Test
    public void getMaintenanceCount() {
    }

    @Test
    public void getMaintenanceList() {
        List<Maintenance> list = maintenanceService.getMaintenanceList(0,10);
        for(Maintenance m:list) {
            System.out.println(m.getUser().getName());
        }
    }

    @Test
    public void deleteMaintenanceById() {
    }

    @Test
    public void addMaintenance() {
    }

    @Test
    public void updateMaintenanceById() {
    }
}