package com.fireengineering.management.service.impl;

import com.fireengineering.management.mapper.DeviceMapper;
import com.fireengineering.management.po.Device;
import com.fireengineering.management.po.DeviceExample;
import com.fireengineering.management.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;

    public int getDeviceCount() {
        DeviceExample example = new DeviceExample();
        return deviceMapper.countByExample(example);

    }

    public Device getDeviceById(Integer deviceId) {
        return deviceMapper.selectByPrimaryKey(deviceId);
    }

    public Device getDeviceByName(String deviceName){
        if(deviceName==null) {
            return null;
        }
        return deviceMapper.selectByName(deviceName);
    }


    public List<Device> getDeviceList(Integer offset, Integer limit) {
        return deviceMapper.selectByLimitAndOffset(offset, limit);
    }

    public int deleteDeviceById(Integer deviceId){
        return deviceMapper.deleteByPrimaryKey(deviceId);
    }

    public int addDevice(Device device) {
        return deviceMapper.insert(device);
    }

    public int updateDeviceById(Device device) {
        return deviceMapper.updateByPrimaryKey(device);
    }
}
