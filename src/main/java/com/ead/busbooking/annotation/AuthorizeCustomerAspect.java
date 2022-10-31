package com.ead.busbooking.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AuthorizeCustomerAspect {
    @Around("@annotation(AuthorizeCustomer)")
    public Object authorize(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("reg");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String isAuthenticated = request.getHeader("isAuthenticated");
        if(isAuthenticated == null || isAuthenticated.equals("false")) {
            throw new Exception("Unauthorized");
        }
        return joinPoint.proceed();
    }





    }
