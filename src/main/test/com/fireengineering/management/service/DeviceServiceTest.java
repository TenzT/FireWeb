package com.fireengineering.management.service;

import com.fireengineering.management.po.Device;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-**.xml"})
public class DeviceServiceTest {
    @Autowired
    DeviceService deviceService;

    @Test
    public void getDeviceCount() {
        System.out.println(deviceService.getDeviceCount());
    }

    @Test
    public void getDeviceById() {
        System.out.println(deviceService.getDeviceById(1).getName());
    }

    @Test
    public void getDeviceList() {
        List<Device> list = deviceService.getDeviceList(0,2);
        for(Device d:list) {
            System.out.println(d.getName()+":"+d.getFiresystem().getName());
        }
    }

    @Test
    public void deleteDeviceById() {
        deviceService.deleteDeviceById(2);
    }

    @Test
    public void addDevice(){
        Device device = new Device();
        device.setName("烟雾传感器");
        device.setFiresystemId(1);
        deviceService.addDevice(device);
    }

    @Test
    public void getDeviceByName() {
        Device device = deviceService.getDeviceByName("消防栓");
        System.out.println(device.getName());
    }

//    @Test
//    public void updateDeviceById() {
//
//    }
}