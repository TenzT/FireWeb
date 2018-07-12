package com.fireengineering.management.service.impl;

import com.fireengineering.management.mapper.PlaceMapper;
import com.fireengineering.management.po.Place;
import com.fireengineering.management.po.PlaceExample;
import com.fireengineering.management.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    PlaceMapper PlaceMapper;

    public int getPlaceCount() {
        PlaceExample example = new PlaceExample();
        return PlaceMapper.countByExample(example);

    }

    public Place getPlaceById(Integer PlaceId) {
        return PlaceMapper.selectByPrimaryKey(PlaceId);
    }

    public Place getPlaceByName(String PlaceName){
        if(PlaceName==null) {
            return null;
        }
        return PlaceMapper.selectByName(PlaceName);
    }


    public List<Place> getPlaceList(Integer offset, Integer limit) {
        return PlaceMapper.selectByLimitAndOffset(offset, limit);
    }

    public int deletePlaceById(Integer PlaceId){
        return PlaceMapper.deleteByPrimaryKey(PlaceId);
    }

    public int addPlace(Place Place) {
        return PlaceMapper.insert(Place);
    }

    public int updatePlaceById(Place Place) {
        return PlaceMapper.updateByPrimaryKey(Place);
    }
}
