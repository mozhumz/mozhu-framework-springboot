package com.hyj.framework.feign;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huyuanjia
 * @date 2019/4/2 11:30
 */
@Slf4j
@Component("DemoFeign")
public class DemoFeignResult {
    private Gson gson = getGson();


    public Gson getGson() {
        GsonBuilder builder = new GsonBuilder();

        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        return builder.create();
    }


//    public User getUserBySn(String sn) {
//        User userManagerUser = null;
//        JsonResponse result = this.userManagementFeign.getUserBySn(sn);
//        if (result != null && result.isStatus()) {
//            if (result.getData() != null) {
//                String str = gson.toJson(result.getData());
//                if (str != null) {
//                    userManagerUser = gson.fromJson(str, User.class);
//                }
//            }
//        } else {
//            log.error("获取用户错误");
//            throw new BaseException(ErrorInfo.USER_MANAGE_WRONG.desc);
//        }
//        return userManagerUser;
//    }


//    public List<String> findAllGrade() {
//        List<String> gradeList = new ArrayList<>();
//        JsonResponse result = userManagementFeign.findAllGrade();
//        if (result != null && result.isStatus()) {
//            if (result.getData() != null) {
//                String str = gson.toJson(result.getData());
//                if (str != null) {
//                    log.error("用户管理findAllGrade出错:" + result);
//                    gradeList = gson.fromJson(str, new TypeToken<List<String>>() {
//                    }.getType());
//                    if (gradeList == null) {
//                        gradeList = new ArrayList<>();
//                    }
//                }
//            }
//        } else {
//            log.error("用户管理系统获取学院用户的学院信息出错:" + result);
//            throw new BaseException(ErrorInfo.USER_MANAGE_WRONG.desc);
//        }
//        return gradeList;
//    }
}
