package com.fireengineering.management.service;

import com.fireengineering.management.po.Place;

import java.util.List;

public interface PlaceService {
    public int getPlaceCount();

    public Place getPlaceById(Integer PlaceId);

    public List<Place> getPlaceList(Integer offset, Integer limit);

    public int deletePlaceById(Integer PlaceId);

    public int addPlace(Place Place);

    public Place getPlaceByName(String PlaceName);

    public int updatePlaceById(Place Place);

    public List<Place> getAllPlace();
}
