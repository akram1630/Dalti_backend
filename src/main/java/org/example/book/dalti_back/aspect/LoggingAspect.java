package org.example.book.dalti_back.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) //run after 0
public class LoggingAspect { //to track name of executed methodes:

    Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut(value = "execution(* org.example.book.dalti_back.repository..*(..))")
    void forRepositoryLog(){}

    @Pointcut(value = "execution(* org.example.book.dalti_back.service..*(..))")
    void forServiceLog(){}

    @Pointcut(value = "execution(* org.example.book.dalti_back.controller..*(..))")
    void forControllerLog(){}

    @Pointcut(value = "forRepositoryLog()||forServiceLog()||forControllerLog()")
    void forAllApp(){}


    @Before(value = "forAllApp()")
    public void beforeMethod(JoinPoint joinPoint){
        //getSignature() == give all path ,,,,,,getName()==give only name
        String methodName = joinPoint.getSignature().getName();
        log.info("=============>MethodName is: >>>> {}",methodName);
        Object[] args = joinPoint.getArgs(); //arguments values in param
        for(Object arg: args)
            log.info("============> with Argument >> {} ",arg);
    }

}
