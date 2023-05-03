package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
        public String hello(Model model){
        model.addAttribute("data","Spring!!");
        return "hello";
        }

    @GetMapping("hello-mvc")
    public String Mvc(@RequestParam("name") String name,Model model){
        model.addAttribute("name",name);
        return "hello-templete";
    }

    @GetMapping("hello-string")
    @ResponseBody //http에서 body부에 데이터를 내가 직접 내가 넣어주겠다
    public String helloString(@RequestParam("name")String name){
        return "hello " + name; // hello spring
    }

    @GetMapping("hello-api") // json형식, 이게 기본이라고함. xml로도 할 수는 있지만 걍 이게 기본.. xml은 무겁다.
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    }
