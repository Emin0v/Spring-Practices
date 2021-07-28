package com.company.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.company.service.*.*(..))")
    public void beforeGetMessage(JoinPoint joinPoint){
        System.out.println("getMessage methodundan evvel : "+joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.company.service.*.*(..))")
    public void afterGetMessage(JoinPoint joinPoint){
        System.out.println("getMessage methodundan sonra : "+joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
