package com.quantasnet.qtrack.profile;

/**
 * This interface provides an abstraction layer and central point
 * to access the SLF4J Profiler.  One profiler will be used per
 * thread and must be completed with the log method.  The start
 * methods will automatically create a profiler for the thread
 * if one does not exist yet.  This is achieved with a ThreadLocal
 * object containing the Profiler.
 *
 * @author quantas
 */
public interface Profiler
{
    void start(String profile);

    void stop();

    void log();
}