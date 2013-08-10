package com.quantasnet.qtrack.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.profiler.Profiler;
import org.slf4j.profiler.ProfilerRegistry;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceProfilingAspect
{
    @Around("execution(* com.quantasnet.qtrack.service.*.*(..))")
    public Object profileService(ProceedingJoinPoint joinPoint) throws Throwable
    {
        final ProfilerRegistry profilerRegistry = ProfilerRegistry.getThreadContextInstance();
        final Profiler serviceProfiler = profilerRegistry.get("Web");
        final Signature signature = joinPoint.getSignature();

        serviceProfiler.startNested(signature.getDeclaringType().getSimpleName() + '.' + signature.getName());

        final Object obj = joinPoint.proceed();

        serviceProfiler.stop();

        return obj;
    }
}