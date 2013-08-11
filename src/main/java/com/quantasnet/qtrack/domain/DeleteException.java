package com.quantasnet.qtrack.domain;

public class DeleteException extends Exception
{
    public DeleteException(String message)
    {
        super(message);
    }

    public DeleteException(String message, Throwable t)
    {
        super(message, t);
    }
}