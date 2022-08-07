package com.example.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component //config에 bean으로 등록 or conpoment로 등록
public class TimeTraceAop {
    @Around("execution(* com.example.hellospring..*(..))") //실행 가능한 패키지 위치
    public Object execute(ProceedingJoinPoint joinPoint)throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
