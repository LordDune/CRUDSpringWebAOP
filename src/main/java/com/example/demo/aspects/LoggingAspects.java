package com.example.demo.aspects;

import com.example.demo.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspects {

    @Around(value = "@annotation(TrackUserAction)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object returnByMethod = joinPoint.proceed();
        System.out.println("Пользователь совершил действие с базой данных: "
                + joinPoint.getSignature().getName()
                + Arrays.asList(joinPoint.getArgs()).get(0).toString());
        return returnByMethod;
    }
}
