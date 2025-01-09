package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName    : hello.hello_spring.controller
 * fileName       : HomeController
 * author         : yoons
 * date           : 2025-01-09
 * description    :
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
