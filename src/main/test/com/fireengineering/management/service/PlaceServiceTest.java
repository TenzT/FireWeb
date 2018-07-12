package com.fireengineering.management.service;

import com.fireengineering.management.po.Place;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-**.xml"})
public class PlaceServiceTest {
    @Autowired
    PlaceService placeService;

    @Test
    public void getPlaceCount() {
    }

    @Test
    public void getPlaceById() {
    }

    @Test
    public void getPlaceList() {
        List<Place> list = placeService.getPlaceList(0,2);
        for(Place p:list) {
            System.out.println(p.getProject().getName() );
        }
    }

    @Test
    public void deletePlaceById() {
    }

    @Test
    public void addPlace() {
    }

    @Test
    public void getPlaceByName() {
    }

    @Test
    public void updatePlaceById() {
    }
}