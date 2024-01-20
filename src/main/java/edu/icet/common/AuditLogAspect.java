package edu.icet.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect//what do see anotation
@Component
@Slf4j
public class AuditLogAspect {
    @Around("@annotation(AuditTime)")
    public Object auditExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime=System.currentTimeMillis();

        Object proceed=joinPoint.proceed();

        long endTime=System.currentTimeMillis()-startTime;
        log.info("Execution time{}ms",endTime);

        return proceed;

    }
}
