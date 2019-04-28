package com.hyj.framework.service;

import com.hyj.framework.model.po.City;

/**
 * @author huyuanjia
 * @date 2019/4/2 17:11
 */
public interface IDemoService {
    City findCityById(String id);



    City saveCity(City city);

    City findCityByName(String name);

    City updateCity(City city);

    void deleteCity(Long id);
}
