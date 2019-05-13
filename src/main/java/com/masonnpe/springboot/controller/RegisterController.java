package com.masonnpe.springboot.controller;

import com.masonnpe.springboot.vo.RegisterVO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class RegisterController {
    @GetMapping("register")
    public String register(@CookieValue(name = "token")String to, @Valid RegisterVO registerVO, BindingResult result, HttpServletRequest request, HttpServletResponse response){
        System.out.println("to:"+to);
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals("token")){
                System.out.println(cookies[i].getValue());
            }
        }

        Cookie cookie=new Cookie("token","dsadasdas");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(100);
        response.addCookie(cookie);
        if (result.hasErrors()) {
            return result.getAllErrors().get(0).getDefaultMessage();
        }
        return "success";
    }
}
