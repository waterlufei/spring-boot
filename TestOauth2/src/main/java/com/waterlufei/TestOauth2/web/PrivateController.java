package com.waterlufei.TestOauth2.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiabin on 2017/8/14.
 */
@RestController
public class PrivateController {

    @PreAuthorize("oauth2.hasScope('read')")
    @RequestMapping(value = "private",method = RequestMethod.GET)
    public String index(){
        return "Hello private!";
    }
}
