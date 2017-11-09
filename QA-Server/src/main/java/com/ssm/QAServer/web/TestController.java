package com.ssm.QAServer.web;

import com.ssm.QAServer.util.Message;
import com.ssm.QAServer.vo.StudentInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiabin on 2017/5/24.
 */
@RestController
@RequestMapping(value = "test")
public class TestController {
    @Autowired
    private HttpServletRequest request;

    public Message message = new Message();

    @ApiOperation(value = "正常接口",notes = "就是一个正常测试的接口")
    @RequestMapping(value = "normal",method =RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String,Object> test(){
        System.out.println("URL:" + request.getRequestURL());
        System.out.println("URI:" + request.getRequestURI());
        System.out.println("参数:" + request.getQueryString());
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("test","这是正常的接口");
        return  map;
    }

    @ApiOperation(value = "模拟报文的测试接口",notes = "就是一个模拟报文的测试接口喽")
    @RequestMapping(value = "message",method =RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String testMessage(@RequestBody StudentInfo studentInfo){
        System.out.println("URL:" + request.getRequestURL());
        System.out.println("URI:" + request.getRequestURI());
        System.out.println("参数:" + request.getQueryString());
        //return "测试HttpServletRequest";
        return message.sendMessage(request,studentInfo);
    }
}
