package com.hyj.framework.web.controller.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;


/*
 */
@Configuration
@Aspect
@EnableAspectJAutoProxy
public class UserAop {


    @Pointcut("@annotation(com.hyj.framework.anno.IsNeed)")
    public void pointCut(){}
//
//    /**
//     * 拦截whut中的控制器，将当前用户写入数据库
//     */
//    @Before("userControllerPoingtCut()")
//    @Transactional
//    public void checkMutualEvaluAopAuther() {
////        User user = userRepository.findByUserName(SessionUtil.getCurrentmentSn());
////        if (user == null) {
////            userRepository.save(SessionUtil.getCurrentUser());
////        }
//    }

    /**
     * 前置通知：目标方法执行之前执行以下方法体的内容
     * controller.*.*(..)) 第一个*表示类 第二个*表示方法  (..)表示方法内部实现
     * @param jp
     */
//    @Before("execution(* com.hyj.framework.web.controller.AopTest.testDemo*(..))")
    public void beforeMethod(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        System.out.println("【前置通知】the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
    }

    @Around( "execution(* com.hyj.framework.web.controller.AopTest.testDemo*(..)))")
    public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aroundMethod"+pjp);
        System.out.println("the method 【" + pjp.getSignature().getName() + "】 begins with " + Arrays.asList(pjp.getArgs()));
        pjp.proceed();//执行被拦截的方法
        System.out.println("after testDemo");
    }

    /**
     * 返回通知：目标方法正常执行完毕时执行以下代码
     * @param jp
     * @param result
     */
    @AfterReturning(value="execution(* com.hyj.framework.web.controller.*.*(..)))",returning="result")
    public void afterReturningMethod(JoinPoint jp, Object result){
        String methodName = jp.getSignature().getName();
        System.out.println("【返回通知】the method 【" + methodName + "】 ends with 【" + result + "】");
    }

    /**
     * 后置通知：目标方法执行之后执行以下方法体的内容，不管是否发生异常。
     * @param jp
     */
    @After("execution(* com.hyj.framework.web.controller.*.*(..)))")
    public void afterMethod(JoinPoint jp){
        System.out.println("【后置通知】this is a afterMethod advice...");
    }

    /**
     * 异常通知：目标方法发生异常的时候执行以下代码
     */
    @AfterThrowing(value="execution(* com.hyj.framework.web.controller.*.*(..)))",throwing="e")
    public void afterThorwingMethod(JoinPoint jp, NullPointerException e){
        String methodName = jp.getSignature().getName();
        System.out.println("【异常通知】the method 【" + methodName + "】 occurs exception: " + e);
    }
}
