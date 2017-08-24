package com.waterlufei.TestOauth2.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiabin on 2017/8/14.
 */
@RestController
public class PublicController {

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/public")
    public String index(){
        return "Hello public!";
    }
}

