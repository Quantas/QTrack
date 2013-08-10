package com.quantasnet.qtrack.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.profiler.ProfilerRegistry;
import org.springframework.stereotype.Component;

@Component
public class ProfilerImpl implements Profiler
{
    private static final Logger LOG = LoggerFactory.getLogger(ProfilerImpl.class);

    private static final ThreadLocal<org.slf4j.profiler.Profiler> profiler = new ThreadLocal<org.slf4j.profiler.Profiler>();

    private static final String WEB_PROFILER = "Web";

    private org.slf4j.profiler.Profiler getThreadLocalProfiler()
    {
        if(profiler.get() == null)
        {
            final org.slf4j.profiler.Profiler profilerInst = new org.slf4j.profiler.Profiler(WEB_PROFILER);
            profilerInst.setLogger(LOG);

            final ProfilerRegistry registry = ProfilerRegistry.getThreadContextInstance();
            profilerInst.registerWith(registry);

            profiler.set(profilerInst);
        }

        return profiler.get();
    }

    private void clearProfiler()
    {
        if(profiler.get() != null)
        {
            profiler.set(null);
        }
    }

    @Override
    public void start(String profile)
    {
        getThreadLocalProfiler().start(profile);
    }

    @Override
    public void stop()
    {
        getThreadLocalProfiler().stop();
    }

    @Override
    public void log()
    {
        getThreadLocalProfiler().log();
        clearProfiler();
    }
}