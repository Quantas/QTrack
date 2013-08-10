package com.quantasnet.qtrack.profile;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This aspect is used to profile everything in the service
 * layer of the application.
 *
 * @author quantas
 */
@Aspect
@Component
public class ProfilingAspect
{
    @Autowired
    private Profiler profiler;

    @Around("execution(* com.quantasnet.qtrack.service.*.*(..)) || execution(* com.quantasnet.qtrack.domain.repo.*.*(..))")
    public Object profile(ProceedingJoinPoint joinPoint) throws Throwable
    {
        final Signature signature = joinPoint.getSignature();
        profiler.start(signature.getDeclaringType().getSimpleName() + '.' + signature.getName());

        return joinPoint.proceed();
    }
}