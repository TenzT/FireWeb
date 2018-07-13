package com.fireengineering.management.service;

import com.fireengineering.management.po.Device;

import java.util.List;

public interface DeviceService {
    public int getDeviceCount();

    public Device getDeviceById(Integer deviceId);

    public List<Device> getDeviceList(Integer offset, Integer limit);

    public int deleteDeviceById(Integer deviceId);

    public int addDevice(Device device);

    public Device getDeviceByName(String deviceName);

    public int updateDeviceById(Device device);

    public List<Device> getAllDevice();
}
