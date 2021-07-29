package com.company.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @After("execution(* com.company.service.impl.StudentServiceImpl.delete(..))")
    public void beforeDelete(JoinPoint joinPoint){
        clearCache();
    }

    @CacheEvict(cacheNames = "studentCache")
    public void clearCache(){
        System.out.println("Cache cleared");
    }
}
