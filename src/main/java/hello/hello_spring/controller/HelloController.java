package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * packageName    : hello.hello_spring.controller
 * fileName       : HelloController
 * author         : yoons
 * date           : 2025-01-08
 * description    :
 */
@Controller
public class HelloController {
    @GetMapping(value = "hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello";
    }

    @GetMapping(value = "hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping(value = "hello-string")
    @ResponseBody
    public String helloString(@RequestParam(name = "name") String name) {
        return "hello " + name;
    }

    @GetMapping(value = "hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(name = "name") String name) {
        Hello hello = new Hello();
        hello.setName("윤수현");
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
