package com.hyj.framework.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * @author caijiang
 * @date 2018/3/8
 */
@FeignClient(value = "user-center")
public interface IDemoFeign {


//    /**
//     * 根据Sn查询学生信息
//     * @param sn
//     * @return
//     */
//    @RequestMapping(value = "/student/api/findStudentInfoBySn/{sn}" ,method = RequestMethod.GET)
//    JsonResponse getStudentBySn(@PathVariable("sn") String sn);

}

