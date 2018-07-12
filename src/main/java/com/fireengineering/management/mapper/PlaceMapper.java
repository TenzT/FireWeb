package com.fireengineering.management.mapper;

import com.fireengineering.management.po.Place;
import com.fireengineering.management.po.PlaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlaceMapper {
    int countByExample(PlaceExample example);

    int deleteByExample(PlaceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Place record);

    int insertSelective(Place record);

    List<Place> selectByExample(PlaceExample example);

    Place selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Place record, @Param("example") PlaceExample example);

    int updateByExample(@Param("record") Place record, @Param("example") PlaceExample example);

    int updateByPrimaryKeySelective(Place record);

    int updateByPrimaryKey(Place record);

    Place selectByName(@Param("placeName") String placeName);

    List<Place> selectByLimitAndOffset(@Param("offset")Integer offset, @Param("limit")Integer limit);
}