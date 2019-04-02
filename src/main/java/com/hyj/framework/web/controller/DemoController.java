package com.hyj.framework.web.controller;

import com.hyj.framework.exception.BaseException;
import com.hyj.framework.exception.ResData;
import com.hyj.framework.model.po.City;
import com.hyj.framework.service.IDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author huyuanjia
 * @date 2019/4/2 16:55
 */
@RestController
@Api(value = "测试相关接口", description = "测试相关接口")
@RequestMapping("/api/demo")
public class DemoController {
    @Resource
    private HttpServletRequest request;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private IDemoService demoService;

    @ApiOperation(value = "获取用户")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object test() {

        System.out.println(stringRedisTemplate);
        stringRedisTemplate.opsForValue().set("hyj","hhhhhwwww123");

        System.out.println(stringRedisTemplate.opsForValue().get("hyj"));

        return "hh";
    }

    @ApiOperation(value = "添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestBody City city) {
        demoService.saveCity(city);

        return new ResData(null);
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object delete(Long id) {
        demoService.deleteCity(id);

        return new ResData(null);
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object update(@RequestBody City city) {
        demoService.updateCity(city);

        return new ResData(null);
    }

    @ApiOperation(value = "查询")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Object find(Long id) {
        System.out.println(demoService.findCityById(id));

        return new ResData(null);
    }


    @ApiOperation(value = "查询")
    @RequestMapping(value = "/find2", method = RequestMethod.GET)
    public Object find2() {
        System.out.println();

        throw new BaseException();
    }
}
