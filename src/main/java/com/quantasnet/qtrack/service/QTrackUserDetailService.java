package com.quantasnet.qtrack.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Custom UserDetailsService that hits the QTrack UserService
 */
@Component
public class QTrackUserDetailService implements UserDetailsService
{
    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return userService.findByUsername(username);
    }
}