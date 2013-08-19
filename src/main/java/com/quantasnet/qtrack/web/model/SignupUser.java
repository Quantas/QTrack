package com.quantasnet.qtrack.web.model;

import com.quantasnet.qtrack.domain.db.User;

public class SignupUser
{
    private User user;
    private String confirmPassword;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getConfirmPassword()
    {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword)
    {
        this.confirmPassword = confirmPassword;
    }
}