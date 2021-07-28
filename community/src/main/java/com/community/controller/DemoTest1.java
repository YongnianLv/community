package com.community.controller;

import com.community.service.ServiceTest;
import com.community.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author lyn
 * @tip Come on!Do your way best!
 * @create 2021.03.24.16:21
 */
@Controller
@RequestMapping("/demo")
public class DemoTest1 {
    @Autowired
    private ServiceTest serviceTest;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "Hello Spring boot";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData() {
        return serviceTest.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String header = request.getHeader(name);
            System.out.println(name + ":" + header);
        }
        System.out.println(request.getParameter("code"));

        //返回相应数据
        response.setContentType("text/html;charset=utf-8");
        try (
                PrintWriter writer = response.getWriter();
        ) {
            writer.write("<h1>校园网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Get
    // /studens?current=1&limit=20
    @RequestMapping(path="/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name="current",required=false,defaultValue="1")int current,
            @RequestParam(name="limit",required=false,defaultValue="10")int limit){
        System.out.println(current);
        System.out.println(limit);
        return "someone";
    }

    // /student/123
    @RequestMapping(path="/student/{id}",method = RequestMethod.GET)
    //爷吐了。。。{id}
    @ResponseBody
    public String getStudent(@PathVariable("id")int id){
        System.out.println(id);
        return "a student";
    }

    //POST请求
    @RequestMapping(path="/student",method = RequestMethod.POST)
    @ResponseBody
    public String save(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //响应HTML数据
    @RequestMapping(path="/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","MrsLi");
        mav.addObject("age",43);
        mav.setViewName("/demo/view");
        return mav;
    }

    //响应JSON数据（异步请求）
    @RequestMapping(path="/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> emp = new HashMap<>();
        emp.put("name", "zhangsan");
        emp.put("age",24);
        emp.put("salary",8888);
        return emp;
    }
    @RequestMapping(path="/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> emp = new HashMap<>();

        emp.put("name", "zhangsan");
        emp.put("age",24);
        emp.put("salary",8888);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "lisi");
        emp.put("age",24);
        emp.put("salary",9999);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "zhangsan");
        emp.put("age",24);
        emp.put("salary",10000);
        list.add(emp);
        return list;
    }
    //cookie example
    @RequestMapping(path="/cookie/set",method = RequestMethod.GET)
    @ResponseBody
    public String setCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("code", CommunityUtil.generateUUID());
        cookie.setPath("/community");
        cookie.setMaxAge(60*10);
        response.addCookie(cookie);
        return "set cookie";
    }

    @RequestMapping(path="/cookie/get",method = RequestMethod.GET)
    @ResponseBody
    public String getCookie(@CookieValue("code") String code){
        System.out.println(code);
        return "get cookie";
    }
    //session example
    @RequestMapping(path="/session/set",method = RequestMethod.GET)
    @ResponseBody
    public String setSession(HttpSession session){
        session.setAttribute("id", "101");
        session.setAttribute("name","hello");
        return "set session";
    }

    @RequestMapping(path="/session/get",method = RequestMethod.GET)
    @ResponseBody
    public String getSession(HttpSession session){
        System.out.println(session.getAttribute("name"));
        System.out.println(session.getAttribute("id"));
        return "get session";
    }
    // ajax示例
    @RequestMapping(path = "/ajax", method = RequestMethod.POST)
    @ResponseBody
    public String testAjax(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return CommunityUtil.getJSONString(0, "操作成功!");
    }
}
