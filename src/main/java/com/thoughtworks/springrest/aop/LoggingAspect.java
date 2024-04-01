package com.thoughtworks.springrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.thoughtworks.springrest.service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method Called :" + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.thoughtworks.springrest.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Executed :" + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.thoughtworks.springrest.service.JobService.*(..))")
    public void logMethodCrashed(JoinPoint jp) {
        LOGGER.info("Method Crashed :" + jp.getSignature().getName());
    }
}
