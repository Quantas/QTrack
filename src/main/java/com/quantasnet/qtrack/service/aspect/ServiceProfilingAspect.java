package com.quantasnet.qtrack.service.aspect;

import com.quantasnet.qtrack.profile.Profiler;
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
public class ServiceProfilingAspect
{
    @Autowired
    private Profiler profiler;

    @Around("execution(* com.quantasnet.qtrack.service.*.*(..))")
    public Object profileService(ProceedingJoinPoint joinPoint) throws Throwable
    {
        final Signature signature = joinPoint.getSignature();
        profiler.startNested(signature.getDeclaringType().getSimpleName() + '.' + signature.getName());

        final Object obj = joinPoint.proceed();

        profiler.stop();

        return obj;
    }
}