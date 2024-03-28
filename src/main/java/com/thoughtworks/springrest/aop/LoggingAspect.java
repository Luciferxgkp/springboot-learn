package com.thoughtworks.springrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.thoughtworks.springrest.service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp) {
        System.out.println("Method Called :" + jp.getSignature().getName());
    }
}
