package com.hyj.framework.service.impl;

/**
 * @author huyuanjia
 * @date 2019/4/2 17:11
 */
import com.hyj.framework.mapper.DemoMapper;
import com.hyj.framework.model.po.City;
import com.hyj.framework.service.IDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 城市业务逻辑实现类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Service

@CacheConfig(cacheNames = "city")
public class DemoServiceImpl implements IDemoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Autowired
    private DemoMapper  cityDao;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取城市逻辑：
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     */
//    @Cacheable(cacheNames = {"city"})
    @Cacheable
    public City findCityById(String id) {
        // 从缓存中获取城市信息
//        String key = "city_" + id;
//        ValueOperations<String, City> operations = redisTemplate.opsForValue();
//
//        // 缓存存在
//        boolean hasKey = redisTemplate.hasKey(key);
//        if (hasKey) {
//            City city = operations.get(key);
//
//            LOGGER.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + city.toString());
//            return city;
//        }
//        operations.set(key, city, 10, TimeUnit.SECONDS);

        // 从 DB 中获取城市信息
        City city = cityDao.selectByPrimaryKey(id);
        System.out.println(city);
//        LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());

        return city;
    }

    @Override
    @CachePut(key = "#city.getId().toString()")
    public City saveCity(City city) {
        cityDao.insert(city);
        System.out.println("add");

        return city;
    }

    @Override
    @Cacheable
    public City findCityByName(String name) {
//        City city=new City();
//        city.setCityName(name);

        Example example = new Example(City.class);
        example.createCriteria()
                .andEqualTo("cityName", name);

        return cityDao.selectOneByExample(example);
    }

    @Override
    @CachePut(key = "#city.getId().toString()")
    public City updateCity(City city) {
         cityDao.updateByPrimaryKey(city);
        System.out.println("update");

//        // 缓存存在，删除缓存
//        String key = "city_" + city.getId();
//        boolean hasKey = redisTemplate.hasKey(key);
//        if (hasKey) {
//            redisTemplate.delete(key);
//
//            LOGGER.info("CityServiceImpl.updateCity() : 从缓存中删除城市 >> " + city.toString());
//        }

        return city;

    }

    @Override
    @CacheEvict(key = "#id.toString()")
    public void deleteCity(Long id) {

        cityDao.deleteByPrimaryKey(id);

//        // 缓存存在，删除缓存
//        String key = "city_" + id;
//        boolean hasKey = redisTemplate.hasKey(key);
//        if (hasKey) {
//            redisTemplate.delete(key);
//
//            LOGGER.info("CityServiceImpl.deleteCity() : 从缓存中删除城市 ID >> " + id);
//        }
        System.out.println("delete");
    }

}
