package com.quantasnet.qtrack.domain.web;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignupUser
{
    @NotNull
    @Size(min = 1, max = 40)
    private String userName;

    @NotNull
    @Size(min = 6, message = "must be at least 6 characters")
    private String password;

    @NotNull
    @Size(min = 6, message = "must be at least 6 characters")
    private String confirmPassword;

    @NotNull
    @Size(min = 1, message = "must not be empty")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "must not be empty")
    private String lastName;

    @NotNull
    @Size(min = 1, message = "must not be empty")
    @Email(message = "must be a valid email address")
    private String email;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getConfirmPassword()
    {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword)
    {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}