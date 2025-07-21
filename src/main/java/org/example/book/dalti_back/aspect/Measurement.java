package org.example.book.dalti_back.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

@Aspect
@Component
@Order(0)
public class Measurement { //TO Get TIME Execution of Methods

    Logger log = LoggerFactory.getLogger(Measurement.class);

    //@Around==execute when start until finish methode to get TIME Execution:
//    @Around(value = "execution(* org.example.book.dalti_back.service..*(..))")
    @Around(value = "execution(* org.example.book.dalti_back.service.ClientService..*(..))")
    public Object logTimeMethode(ProceedingJoinPoint joinPoint) throws Throwable {
        //ProceedingJoinPoint---->to get method's info
        long startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder("KPI"); ////KPI==TIME EXEC
        stringBuilder
                .append("[")
                .append(joinPoint.getKind())
                .append("]\tfor: ")
                .append(joinPoint.getSignature())
                .append("\twith Args: ")
                .append("(")
                .append(StringUtils.join(joinPoint.getArgs(), ","))
                .append(")");

        stringBuilder.append("\ttook: ");
        Object returnValue = joinPoint.proceed();
        log.info(stringBuilder.append(System.currentTimeMillis() - startTime).append(" ms").toString());
        return returnValue;
    }

}
