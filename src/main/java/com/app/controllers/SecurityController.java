package com.app.controllers;

import com.app.config.SecurityUtils;
import com.app.entities.AppUser;
import com.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurityController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/security/account", method = RequestMethod.GET)
    public @ResponseBody
    AppUser getUserAccount() {
        AppUser user = userRepository.findByEmail(SecurityUtils.getCurrentLogin());
        if(user!=null)
            user.setPassword(null);
        return user;
    }

    //Only for test
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody
    String getText() {
        return "Text only for admin";
    }
}
