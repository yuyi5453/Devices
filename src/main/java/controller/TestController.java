package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {


    
    @RequestMapping("/")
    public String t(HttpServletRequest request){
        System.out.println(request);
        return null;
    }
}
