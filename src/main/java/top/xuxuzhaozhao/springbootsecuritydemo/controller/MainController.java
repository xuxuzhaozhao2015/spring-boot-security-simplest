package top.xuxuzhaozhao.springbootsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 映射到springboot的templates文件夹
     * @return
     */
    @RequestMapping("/403")
    public String forbidden(){
        return "403";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
