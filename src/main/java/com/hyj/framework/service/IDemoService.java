package com.hyj.framework.service;

import com.hyj.framework.model.po.City;

/**
 * @author huyuanjia
 * @date 2019/4/2 17:11
 */
public interface IDemoService {
    City findCityById(Long id);

    void saveCity(City city);

    void updateCity(City city);

    void deleteCity(Long id);
}
