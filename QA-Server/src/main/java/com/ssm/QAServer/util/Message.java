package com.ssm.QAServer.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by xiabin on 2017/5/24.
 */
public class Message {

    private final Logger logger = Logger.getLogger(getClass());

    public String sendMessage(HttpServletRequest request, Object inputContent){

        //得到URI
        String uri = request.getRequestURI();

        //获取request的json数据，取出所有的键
        String requestContent = JSON.toJSONString(inputContent);
        JSONObject jsonObject = JSON.parseObject(requestContent);
        Set set = jsonObject.keySet();
        //读取事先写在request的txt内容
        String fileRequestPath = "message" + uri +".json";

        String fileContent="";
        try{
            File file = new File(fileRequestPath);
            fileContent=txt2String(file);
        }catch (Exception e){
            return "请求接口地址错误或文件内部数据不是json";
        }
        logger.info(fileContent);
        //获取txt的json数据，取出所有的键
        JSONObject jsonFile = JSON.parseObject(fileContent);
        Set setFile = jsonFile.keySet();

        //比较输入的键是不是合乎规范
        boolean check = isSetEqual(set,setFile);
        if(check){
            //如果输入的格式和字段都正确，返回写好的txt报文json格式数据
            String fileResponsePath = "message" + uri +"Response"+".json";
            String rightFile = "";
            try{
                File fileResponse = new File(fileResponsePath);
                rightFile=txt2String(fileResponse);
            }catch (Exception e){
                return "响应报文地址错误或文件内部数据不是json";
            }
            JSONObject rightResponse = JSON.parseObject(rightFile);
            return rightResponse.toString();
        }else {
            //如果输入的格式或字段不正确，返回写好的错误数据
            String fileResponsePath = "message/error/requestError.json";
            String errorFile = "";
            try{
                File fileResponse = new File(fileResponsePath);
                errorFile=txt2String(fileResponse);
            }catch (Exception e){
                return "响应报文地址错误或文件内部数据不是json";
            }
            JSONObject errorResponse = JSON.parseObject(errorFile);
            return errorResponse.toString();
        }
    }

    //读取txt文件的内容，输出String格式
    /**/public  String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

    //获取request请求的内容
    public  String readRequestBody(HttpServletRequest request){
        InputStream inputStream = null;
        BufferedInputStream buf = null;
        StringBuffer requestJsonBuffer = null;
        try {
            inputStream = request.getInputStream();
            buf = new BufferedInputStream(inputStream);
            byte[] buffer = new byte[1024];
            requestJsonBuffer = new StringBuffer();
            int a = 0;
            while ((a = buf.read(buffer)) != -1){
                requestJsonBuffer.append(new String(buffer, 0, a, "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //关闭连接
            if (null != buf){
                try {
                    buf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null == requestJsonBuffer ? null : requestJsonBuffer.toString();
    }

    //用来比较两个Set是否相等，用来比较request内容的键是不是一样的
    public  boolean isSetEqual(Set set1, Set set2) {

        if (set1 == null && set2 == null) {
            return true; // Both are null
        }

        if (set1 == null || set2 == null || set1.size() != set2.size()
                || set1.size() == 0 || set2.size() == 0) {
            return false;
        }

        Iterator ite2 = set2.iterator();
        boolean isFullEqual = true;

        while (ite2.hasNext()) {
            if (!set1.contains(ite2.next())) {
                isFullEqual = false;
            }
        }

        return isFullEqual;
    }

}
