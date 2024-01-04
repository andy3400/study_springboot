package cookielabs.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String hellomvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hell-template";
    }

    @GetMapping("hello-spring")
    @ResponseBody  // response body 영역에 return 부분을 넣는다.
    public String helloSpring(@RequestParam("name") String name){
        return "hello" + name; // hello spring
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello hellpApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
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
